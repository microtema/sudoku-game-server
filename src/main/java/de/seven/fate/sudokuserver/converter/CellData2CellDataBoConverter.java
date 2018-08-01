package de.seven.fate.sudokuserver.converter;

import de.seven.fate.sudoku.model.CellData;
import de.seven.fate.sudokuserver.bo.CellDataBO;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

@Component
public class CellData2CellDataBoConverter implements ExtendedConverter<CellData, CellDataBO> {


    private final PositionData2CellDataBoConverter positionData2CellDataBoConverter;

    public CellData2CellDataBoConverter(PositionData2CellDataBoConverter positionData2CellDataBoConverter) {
        this.positionData2CellDataBoConverter = positionData2CellDataBoConverter;
    }

    public void update(CellData source, CellDataBO target) {
        Validate.notNull(source);
        Validate.notNull(target);

        target.setValue(source.getValue());
        positionData2CellDataBoConverter.update(source.getPositionData(), target);
    }

    @Override
    public CellDataBO createInstance() {

        return new CellDataBO();
    }
}
