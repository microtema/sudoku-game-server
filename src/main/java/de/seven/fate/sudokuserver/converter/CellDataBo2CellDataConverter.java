package de.seven.fate.sudokuserver.converter;

import de.seven.fate.sudoku.model.CellData;
import de.seven.fate.sudoku.model.PositionData;
import de.seven.fate.sudokuserver.bo.CellDataBO;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

@Component
public class CellDataBo2CellDataConverter implements ExtendedConverter<CellDataBO, CellData> {

    @Override
    public CellData convert(CellDataBO source) {

        CellData cellData = new CellData(new PositionData(source.getRowIndex(), source.getColumnIndex()), null, null, null);

        update(source, cellData);

        return cellData;
    }

    @Override
    public void update(CellDataBO source, CellData target) {
        Validate.notNull(source);
        Validate.notNull(target);

        target.setValue(source.getValue());
    }
}
