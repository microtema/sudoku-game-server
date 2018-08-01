package de.seven.fate.sudokuserver.converter;

import de.seven.fate.sudoku.model.PositionData;
import de.seven.fate.sudokuserver.bo.CellDataBO;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

@Component
public class PositionData2CellDataBoConverter implements ExtendedConverter<PositionData, CellDataBO> {

    public void update(PositionData source, CellDataBO target) {
        Validate.notNull(source);
        Validate.notNull(target);

        target.setColumnIndex(source.getColumnIndex());
        target.setRowIndex(source.getRowIndex());
    }

    @Override
    public CellDataBO createInstance() {

        return new CellDataBO();
    }
}
