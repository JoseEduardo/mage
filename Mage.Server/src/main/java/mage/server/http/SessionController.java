package mage.server.http;

import mage.MageException;
import mage.interfaces.callback.ClientCallback;
import mage.server.Session;
import mage.server.SessionManager;
import mage.server.User;
import mage.server.http.util.JwtAuthHelper;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/session")
public class SessionController {

    @RequestMapping(value = "create_session/{sessionId}", method = RequestMethod.POST)
    public Session createSession(@PathVariable String sessionId,
                                 @RequestHeader(value = "Authorization") String jwt) {
        return SessionManager.instance.createSession(sessionId);
    }

    @RequestMapping(value = "connect_user/{sessionId}/{password}", method = RequestMethod.POST)
    public boolean connectUser(@PathVariable String sessionId,
                               @PathVariable String password,
                               @RequestHeader(value = "Authorization") String jwt) throws MageException {
        String userName = JwtAuthHelper.getUserName(jwt);
        return SessionManager.instance.connectUser(sessionId, userName, password, "");
    }

    @RequestMapping(value = "get_callback/{sessionId}", method = RequestMethod.GET)
    public ClientCallback getCallback(@PathVariable String sessionId,
                                      @RequestHeader(value = "Authorization") String jwt) throws MageException {
        Optional<User> user = JwtAuthHelper.deriveUserFromJwt(jwt);

        Optional<Session> optSession = SessionManager.instance.getSession(sessionId);
        if (!optSession.isPresent()) {
            throw new IllegalArgumentException("SessionId not found.");
        }
        Session session = optSession.get();
        if (!session.getUserId().equals(user.get().getId())) {
            throw new IllegalArgumentException("Illegal User for SessionId not found.");
        }

        return session.getCallbackForPulling();
    }

    @RequestMapping(value = "clear_callback/{sessionId}", method = RequestMethod.POST)
    public void clearCallback(@PathVariable String sessionId,
                                      @RequestHeader(value = "Authorization") String jwt) throws MageException {
        Optional<User> user = JwtAuthHelper.deriveUserFromJwt(jwt);

        Optional<Session> optSession = SessionManager.instance.getSession(sessionId);
        if (!optSession.isPresent()) {
            throw new IllegalArgumentException("SessionId not found.");
        }
        Session session = optSession.get();
        if (!session.getUserId().equals(user.get().getId())) {
            throw new IllegalArgumentException("Illegal User for SessionId not found.");
        }

        session.setCallbackForPulling(new ClientCallback());
    }

}
