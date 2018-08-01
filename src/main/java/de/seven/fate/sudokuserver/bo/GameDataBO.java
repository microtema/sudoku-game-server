package de.seven.fate.sudokuserver.bo;

import java.util.ArrayList;
import java.util.List;

public class GameDataBO {

    private String message;

    private List<RowDataBO> rows = new ArrayList<>();

    public List<RowDataBO> getRows() {
        return rows;
    }

    public void setRows(List<RowDataBO> rows) {
        this.rows = rows;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
