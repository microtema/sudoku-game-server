package de.seven.fate.sudokuserver.bo;

import java.util.ArrayList;
import java.util.List;

public class RowDataBO {

    private List<CellDataBO> cells = new ArrayList<>();

    private int index;

    public List<CellDataBO> getCells() {
        return cells;
    }

    public void setCells(List<CellDataBO> cells) {
        this.cells = cells;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
