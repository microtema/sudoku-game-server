package de.seven.fate.sudokuserver.converter;

import de.seven.fate.sudoku.model.RowData;
import de.seven.fate.sudokuserver.bo.RowDataBO;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

@Component
public class RowData2RowDataBoConverter implements ExtendedConverter<RowData, RowDataBO> {

    private final CellData2CellDataBoConverter cellData2CellDataBoConverter;

    public RowData2RowDataBoConverter(CellData2CellDataBoConverter cellData2CellDataBoConverter) {
        this.cellData2CellDataBoConverter = cellData2CellDataBoConverter;
    }

    public void update(RowData source, RowDataBO target) {
        Validate.notNull(source);
        Validate.notNull(target);

        target.setIndex(source.getIndex());
        target.setCells(cellData2CellDataBoConverter.convertToList(source.getCells()));
    }

    @Override
    public RowDataBO createInstance() {

        return new RowDataBO();
    }
}
