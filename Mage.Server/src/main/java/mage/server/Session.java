/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:
*
*    1. Redistributions of source code must retain the above copyright notice, this list of
*       conditions and the following disclaimer.
*
*    2. Redistributions in binary form must reproduce the above copyright notice, this list
*       of conditions and the following disclaimer in the documentation and/or other materials
*       provided with the distribution.
*
* THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
* ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* The views and conclusions contained in the software and documentation are those of the
* authors and should not be interpreted as representing official policies, either expressed
* or implied, of BetaSteward_at_googlemail.com.
*/

package mage.server;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mage.MageException;
import mage.interfaces.callback.ClientCallback;
import mage.players.net.UserData;
import mage.players.net.UserGroup;
import mage.server.game.GamesRoomManager;
import mage.server.util.ConfigSettings;
import mage.view.UserDataView;
import org.apache.log4j.Logger;
import org.jboss.remoting.callback.AsynchInvokerCallbackHandler;
import org.jboss.remoting.callback.Callback;
import org.jboss.remoting.callback.HandleCallbackException;
import org.jboss.remoting.callback.InvokerCallbackHandler;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class Session {

    private static final Logger logger = Logger.getLogger(Session.class);

    private final String sessionId;
    private UUID userId;
    private String host;
    private int messageId = 0;
    private final Date timeConnected;
    private boolean isAdmin = false;
    private final AsynchInvokerCallbackHandler callbackHandler;

    private final ReentrantLock lock;

    public Session(String sessionId, InvokerCallbackHandler callbackHandler) {
        this.sessionId = sessionId;
        this.callbackHandler = (AsynchInvokerCallbackHandler) callbackHandler;
        this.isAdmin = false;
        this.timeConnected = new Date();
        this.lock = new ReentrantLock();
    }

    public String registerUser(String userName) throws MageException {
        String returnMessage = registerUserHandling(userName);
        if (returnMessage != null) {
            sendErrorMessageToClient(returnMessage);
        }
        return returnMessage;
    }

    public boolean isLocked() {
        return lock.isLocked();
    }

    public String registerUserHandling(String userName) throws MageException {
        this.isAdmin = false;
        if (userName.equals("Admin")) {
            return "User name Admin already in use";
        }
        if (userName.length() > ConfigSettings.getInstance().getMaxUserNameLength()) {
            return new StringBuilder("User name may not be longer than ").append(ConfigSettings.getInstance().getMaxUserNameLength()).append(" characters").toString();
        }
        if (userName.length() < ConfigSettings.getInstance().getMinUserNameLength()) {
            return new StringBuilder("User name may not be shorter than ").append(ConfigSettings.getInstance().getMinUserNameLength()).append(" characters").toString();
        }
        Pattern p = Pattern.compile(ConfigSettings.getInstance().getUserNamePattern(), Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(userName);
        if (m.find()) {
            return new StringBuilder("User name '").append(userName).append("' includes not allowed characters: use a-z, A-Z and 0-9").toString();
        }
        User user = UserManager.getInstance().createUser(userName, host);
        boolean reconnect = false;
        if (user == null) {  // user already exists
            user = UserManager.getInstance().findUser(userName);
            if (user.getHost().equals(host)) {
                user.updateLastActivity(null);  // minimizes possible expiration
                this.userId = user.getId();
                if (user.getSessionId().isEmpty()) {
                    logger.info("Reconnecting session for " + userName);
                    reconnect = true;
                } else {
                    //disconnect previous session
                    logger.info("Disconnecting another user instance: " + userName);
                    SessionManager.getInstance().disconnect(user.getSessionId(), DisconnectReason.ConnectingOtherInstance);
                }
            } else {
                return new StringBuilder("User name ").append(userName).append(" already in use (or your IP address changed)").toString();
            }
        }
        if (!UserManager.getInstance().connectToSession(sessionId, user.getId())) {
            return new StringBuilder("Error connecting ").append(userName).toString();
        }        
        this.userId = user.getId();
        if (reconnect) { // must be connected to receive the message
            UUID chatId = GamesRoomManager.getInstance().getRoom(GamesRoomManager.getInstance().getMainRoomId()).getChatId();
            if (chatId != null) {
                ChatManager.getInstance().joinChat(chatId, userId);
            }
            ChatManager.getInstance().sendReconnectMessage(userId);
        }        
        return null;
    }

    public void registerAdmin() {
        this.isAdmin = true;
        User user = UserManager.getInstance().createUser("Admin", host);
        if (user == null) {
            user = UserManager.getInstance().findUser("Admin");
        }
        user.setUserData(new UserData(UserGroup.ADMIN, 0, false, false, null));
        if (!UserManager.getInstance().connectToSession(sessionId, user.getId())) {
               logger.info("Error connecting Admin!");
        }        
        this.userId = user.getId();
    }

    public boolean setUserData(String userName, UserDataView userDataView) {
        User user = UserManager.getInstance().findUser(userName);
        if (user != null) {
            UserData userData = user.getUserData();
            if (userData == null) {
                userData = new UserData(UserGroup.PLAYER, userDataView.getAvatarId(), userDataView.isShowAbilityPickerForced(), userDataView.allowRequestShowHandCards(), userDataView.getUserSkipPrioritySteps());
                user.setUserData(userData);
            } else {
                if (userDataView.getAvatarId() == 51) { // Update special avatar if first avatar is selected
                    updateAvatar(userName, userData);
                }
                userData.setAvatarId(userDataView.getAvatarId());                
                userData.setShowAbilityPickerForced(userDataView.isShowAbilityPickerForced());
                userData.setAllowRequestShowHandCards(userDataView.allowRequestShowHandCards());
                userData.setUserSkipPrioritySteps(userDataView.getUserSkipPrioritySteps());
            }
            return true;
        }
        return false;
    }

    private void updateAvatar(String userName, UserData userData) {
        //TODO: move to separate class
        //TODO: add for checking for private key
        switch (userName) {
            case "nantuko":
                userData.setAvatarId(1000);
                break;
            case "i_no_k":
                userData.setAvatarId(1002);
                break;
            case "Askael":
                userData.setAvatarId(1004);
                break;
            case "North":
                userData.setAvatarId(1006);
                break;
            case "BetaSteward":
                userData.setAvatarId(1008);
                break;
            case "Arching":
                userData.setAvatarId(1010);
                break;
            case "loki":
                userData.setAvatarId(1012);
                break;
            case "Alive":
                userData.setAvatarId(1014);
                break;
            case "Rahan":
                userData.setAvatarId(1016);
                break;
            case "Ayrat":
                userData.setAvatarId(1018);
                break;
            case "Bandit":
                userData.setAvatarId(1020);
                break;
        }
    }

    public String getId() {
        return sessionId;
    }

    // because different threads can activate this
    public void  userLostConnection() {
        boolean lockSet = false;
        try {
            if(lock.tryLock(5000, TimeUnit.MILLISECONDS)) {
                lockSet = true;
                logger.debug("SESSION LOCK SET sessionId: " + sessionId);
            } else {
                logger.error("CAN'T GET LOCK - userId: " + userId);
            }
            User user = UserManager.getInstance().getUser(userId);
            if (user == null || !user.isConnected()) {
                return; //user was already disconnected by other thread
            }
            if (!user.getSessionId().equals(sessionId)) {
                // user already reconnected with another instance
                logger.info("OLD SESSION IGNORED - " + user.getName());
                return;
            }
            // logger.info("LOST CONNECTION - " + user.getName() + " id: " + userId);
            UserManager.getInstance().disconnect(userId, DisconnectReason.LostConnection);

        } catch (InterruptedException ex) {
            logger.error("SESSION LOCK lost connection - userId: " + userId, ex);
        }
        finally {
            if (lockSet)    {
                lock.unlock();
                logger.trace("SESSION LOCK UNLOCK sessionId: " + sessionId);
            }
        }

    }

    public void kill(DisconnectReason reason) {
        boolean lockSet = false;
        try {
            if(lock.tryLock(5000, TimeUnit.MILLISECONDS)) {
                lockSet = true;
                logger.debug("SESSION LOCK SET sessionId: " + sessionId);                
            } else {
                logger.error("SESSION LOCK - kill: userId " + userId);
            }
            UserManager.getInstance().removeUser(userId, reason);
        } catch (InterruptedException ex) {
            logger.error("SESSION LOCK - kill: userId " + userId, ex);
        }
        finally {
            if (lockSet)    {
                lock.unlock();
                logger.debug("SESSION LOCK UNLOCK sessionId: " + sessionId);

            }
        }

    }

    public void fireCallback(final ClientCallback call) {
        try {
            call.setMessageId(messageId++);
            callbackHandler.handleCallbackOneway(new Callback(call));
        } catch (HandleCallbackException ex) {
            User user = UserManager.getInstance().getUser(userId);
            logger.warn("SESSION CALLBACK EXCEPTION - " + (user != null ? user.getName():"") + " userId " + userId);
            logger.warn(" - method: " + call.getMethod());
            logger.warn(" - cause: " + getBasicCause(ex).toString());
            logger.trace("Stack trace:", ex);
            userLostConnection();
        }
    }

    public UUID getUserId() {
        return userId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getHost() {
        return host;
    }

    public Date getConnectionTime() {
        return timeConnected;
    }

    void setHost(String hostAddress) {
        this.host = hostAddress;
    }

    void sendErrorMessageToClient(String message) {
        List<String> messageData = new LinkedList<>();
        messageData.add("Error while connecting to server");
        messageData.add(message);
        fireCallback(new ClientCallback("showUserMessage", null, messageData));
    }

    public static Throwable getBasicCause(Throwable cause) {
        Throwable t = cause;
        while (t.getCause() != null) {
            t = t.getCause();
            if (t == cause) {
                throw new IllegalArgumentException("Infinite cycle detected in causal chain");
            }
        }
        return t;
    }
}
