package mage.server.http;

import mage.MageException;
import mage.game.Table;
import mage.game.match.MatchOptions;
import mage.server.TableManager;
import mage.server.User;
import mage.server.game.GamesRoomImpl;
import mage.server.http.util.JwtAuthHelper;
import mage.server.tables.PlayerTable;
import mage.view.TableView;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/tables")
public class TablesController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<TableView> index(@RequestHeader(value = "Authorization") String jwt) {
        List<TableView> list = new ArrayList<TableView>();

        for (Table tbl : TableManager.instance.getTables()) {
            list.add(new TableView(tbl));
        }

        return list;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TableView show(@PathVariable String id,
                          @RequestHeader(value = "Authorization") String jwt) {
        return new TableView(TableManager.instance.getTable(UUID.fromString(id)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public TableView delete(@PathVariable String id,
                            @RequestHeader(value = "Authorization") String jwt) {
        return new TableView(TableManager.instance.getTable(UUID.fromString(id)));
    }


    @RequestMapping(value = "/create_table", method = RequestMethod.POST)
    public TableView createTable(@RequestBody MatchOptions options,
                                 @RequestHeader(value = "Authorization") String jwt) {

        GamesRoomImpl gamesRoom = new GamesRoomImpl();
        Optional<User> user = JwtAuthHelper.deriveUserFromJwt(jwt);
        return gamesRoom.createTable(user.get().getId(), options);
        //return new TableView(TableManager.instance.createTable(GamesRoomManager.instance.getMainRoomId(), options));
    }

    @RequestMapping(value = "/join_table/{idTable}", method = RequestMethod.POST)
    public boolean joinTable(@RequestBody PlayerTable options,
                             @PathVariable String idTable,
                             @RequestHeader(value = "Authorization") String jwt) throws MageException {

        Optional<User> user = JwtAuthHelper.deriveUserFromJwt(jwt);
        return TableManager.instance.joinTable(user.get().getId(), UUID.fromString(idTable), options.getName()
            , options.getPlayerType(), options.getSkill(), options.getDeckList(), options.getPassword());
    }

    @RequestMapping(value = "/start_match/{idTable}", method = RequestMethod.POST)
    public void startMatch(@PathVariable String idTable,
                              @RequestHeader(value = "Authorization") String jwt) {

        Optional<User> user = JwtAuthHelper.deriveUserFromJwt(jwt);
        TableManager.instance.startMatch(user.get().getId(), UUID.fromString(""), UUID.fromString(idTable));
    }

}
