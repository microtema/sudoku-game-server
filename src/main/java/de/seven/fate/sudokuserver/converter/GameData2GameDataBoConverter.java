package de.seven.fate.sudokuserver.converter;

import de.seven.fate.sudoku.model.GameData;
import de.seven.fate.sudokuserver.bo.GameDataBO;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

@Component
public class GameData2GameDataBoConverter implements ExtendedConverter<GameData, GameDataBO> {

    private final RowData2RowDataBoConverter rowData2RowDataBoConverter;

    public GameData2GameDataBoConverter(RowData2RowDataBoConverter rowData2RowDataBoConverter) {
        this.rowData2RowDataBoConverter = rowData2RowDataBoConverter;
    }

    public void update(GameData source, GameDataBO target) {
        Validate.notNull(source);
        Validate.notNull(target);

        target.setRows(rowData2RowDataBoConverter.convertToList(source.getRows()));
    }

    @Override
    public GameDataBO createInstance() {

        return new GameDataBO();
    }
}
