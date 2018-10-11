package mage.server.http;

import com.google.gson.GsonBuilder;
import mage.constants.ManaType;
import mage.constants.PlayerAction;
import mage.server.User;
import mage.server.game.GameManager;
import mage.server.http.util.JwtAuthHelper;
import mage.view.GameView;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/games")
public class GamesController {

    @RequestMapping(value = "/{gameId}/players/{playerId}", method = RequestMethod.GET)
    public String show(@PathVariable String gameId,
                       @PathVariable String playerId,
                       @RequestHeader(value = "Authorization") String jwt) {

        Optional<User> user = JwtAuthHelper.deriveUserFromJwt(jwt);

        GameView gv = GameManager.instance.getGameView(
            UUID.fromString(gameId),
            user.get().getId(),
            UUID.fromString(playerId)
        );

        if (gv != null) {
            return new GsonBuilder().create().toJson(gv);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "join_game/{gameId}", method = RequestMethod.POST)
    public void joinGame(@PathVariable String gameId,
                         @RequestHeader(value = "Authorization") String jwt) {
        Optional<User> user = JwtAuthHelper.deriveUserFromJwt(jwt);

        GameManager.instance.joinGame(UUID.fromString(gameId), user.get().getId());
    }

    @RequestMapping(value = "quit_match/{gameId}", method = RequestMethod.POST)
    public void quitMatch(@PathVariable String gameId,
                         @RequestHeader(value = "Authorization") String jwt) {
        Optional<User> user = JwtAuthHelper.deriveUserFromJwt(jwt);

        GameManager.instance.quitMatch(UUID.fromString(gameId), user.get().getId());
    }

    @RequestMapping(value = "watch_game/{gameId}", method = RequestMethod.POST)
    public void watchGame(@PathVariable String gameId,
                          @RequestHeader(value = "Authorization") String jwt) {
        Optional<User> user = JwtAuthHelper.deriveUserFromJwt(jwt);

        GameManager.instance.watchGame(UUID.fromString(gameId), user.get().getId());
    }

    @RequestMapping(value = "stop_watching/{gameId}", method = RequestMethod.POST)
    public void stopWatching(@PathVariable String gameId,
                          @RequestHeader(value = "Authorization") String jwt) {
        Optional<User> user = JwtAuthHelper.deriveUserFromJwt(jwt);

        GameManager.instance.stopWatching(UUID.fromString(gameId), user.get().getId());
    }

    @RequestMapping(value = "/{gameId}/players/{playerId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String gameId,
                         @PathVariable String playerId,
                         @RequestHeader(value = "Authorization", required = false) String jwt) {

        Optional<User> user = JwtAuthHelper.deriveUserFromJwt(jwt);

        GameView gv = GameManager.instance.getGameView(
            UUID.fromString(gameId),
            user.get().getId(),
            UUID.fromString(playerId)
        );

        if (gv != null) {
            return new GsonBuilder().create().toJson(gv);
        } else {
            return null;
        }
    }

    @PutMapping("/{gameId}/send_uuid/{uuid}")
    public void playerSendUuid(@PathVariable String gameId,
                               @PathVariable String uuid,
                               @RequestHeader(value = "Authorization", required = false) String jwt) {

        Optional<User> user = JwtAuthHelper.deriveUserFromJwt(jwt);

        GameManager.instance.sendPlayerUUID(
            UUID.fromString(gameId),
            user.get().getId(),
            UUID.fromString(uuid)
        );
    }

    @PutMapping("/{gameId}/send_integer/{value}")
    public void playerSendInteger(@PathVariable String gameId,
                                  @PathVariable Integer value,
                                  @RequestHeader(value = "Authorization", required = false) String jwt) {

        Optional<User> user = JwtAuthHelper.deriveUserFromJwt(jwt);

        GameManager.instance.sendPlayerInteger(
            UUID.fromString(gameId),
            user.get().getId(),
            value
        );
    }

    @PutMapping("/{gameId}/send_boolean/{value}")
    public void playerSendBoolean(@PathVariable String gameId,
                                  @PathVariable Boolean value,
                                  @RequestHeader(value = "Authorization", required = false) String jwt) {

        Optional<User> user = JwtAuthHelper.deriveUserFromJwt(jwt);

        GameManager.instance.sendPlayerBoolean(
            UUID.fromString(gameId),
            user.get().getId(),
            value
        );
    }

    @PutMapping("/{gameId}/send_string/{value}")
    public void playerSendString(@PathVariable String gameId,
                                 @PathVariable String value,
                                 @RequestHeader(value = "Authorization", required = false) String jwt) {

        Optional<User> user = JwtAuthHelper.deriveUserFromJwt(jwt);

        GameManager.instance.sendPlayerString(
            UUID.fromString(gameId),
            user.get().getId(),
            value
        );
    }

    @PutMapping("/{gameId}/players/{playerId/send_mana_type/{value}")
    public void playerSendManaType(@PathVariable String gameId,
                                   @PathVariable String playerId,
                                   @PathVariable String value,
                                   @RequestHeader(value = "Authorization", required = false) String jwt) {

        Optional<User> user = JwtAuthHelper.deriveUserFromJwt(jwt);

        GameManager.instance.sendPlayerManaType(
            UUID.fromString(gameId),
            UUID.fromString(playerId),
            user.get().getId(),
            ManaType.valueOf(value)
        );
    }

    @PutMapping("/{gameId}/send/{action}")
    public void playerSendAction(@PathVariable String gameId,
                                 @PathVariable String action,
                                 @RequestBody String value,
                                 @RequestHeader(value = "Authorization", required = false) String jwt) {

        Optional<User> user = JwtAuthHelper.deriveUserFromJwt(jwt);

        GameManager.instance.sendPlayerAction(
            PlayerAction.valueOf(action),
            UUID.fromString(gameId),
            user.get().getId(),
            ManaType.valueOf(value)
        );
    }

    @PutMapping("/{gameId}/get_chat_id")
    public Optional<UUID> getChatId(@PathVariable String gameId,
                                    @RequestHeader(value = "Authorization", required = false) String jwt) {

        JwtAuthHelper.deriveUserFromJwt(jwt)
            .orElseThrow(() -> new IllegalArgumentException("Not Authorized."));
        return GameManager.instance.getChatId(
            UUID.fromString(gameId)
        );
    }

}
