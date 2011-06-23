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

package mage.server.draft;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import mage.game.draft.Draft;
import mage.view.DraftPickView;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class DraftManager {
	private final static DraftManager INSTANCE = new DraftManager();

	public static DraftManager getInstance() {
		return INSTANCE;
	}

	private DraftManager() {}

	private ConcurrentHashMap<UUID, DraftController> draftControllers = new ConcurrentHashMap<UUID, DraftController>();

	public UUID createDraftSession(Draft draft, ConcurrentHashMap<String, UUID> sessionPlayerMap, UUID tableId) {
		DraftController draftController = new DraftController(draft, sessionPlayerMap, tableId);
		draftControllers.put(draft.getId(), draftController);
		return draftController.getSessionId();
	}

	public void joinDraft(UUID draftId, String sessionId) {
		draftControllers.get(draftId).join(sessionId);
	}

	public void destroyChatSession(UUID gameId) {
		draftControllers.remove(gameId);
	}

	public DraftPickView sendCardPick(UUID draftId, String sessionId, UUID cardId) {
		return draftControllers.get(draftId).sendCardPick(sessionId, cardId);
	}

	public void removeSession(String sessionId) {
		for (DraftController controller: draftControllers.values()) {
			controller.kill(sessionId);
		}
	}

	public void kill(UUID draftId, String sessionId) {
		draftControllers.get(draftId).kill(sessionId);
	}

	public void timeout(UUID gameId, String sessionId) {
		draftControllers.get(gameId).timeout(sessionId);
	}

	public void removeDraft(UUID draftId) {
		draftControllers.remove(draftId);
	}

}
