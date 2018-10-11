package mage.server.http;

import mage.MageException;
import mage.server.Session;
import mage.server.SessionManager;
import mage.server.http.util.JwtAuthHelper;
import org.springframework.web.bind.annotation.*;

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

}
