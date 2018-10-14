package mage.view;

import java.util.List;

public class TableViewList {

    private List<TableView> tables;

    public TableViewList() {
    }

    public TableViewList(List<TableView> tables) {
        this.tables = tables;
    }

    public List<TableView> getTables() {
        return tables;
    }

    public void setTables(List<TableView> tables) {
        this.tables = tables;
    }
}
