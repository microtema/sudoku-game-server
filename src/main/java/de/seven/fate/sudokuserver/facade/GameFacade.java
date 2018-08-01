package de.seven.fate.sudokuserver.facade;

import de.seven.fate.sudoku.GameService;
import de.seven.fate.sudoku.enums.GameLevel;
import de.seven.fate.sudoku.exceptions.InvalidValueException;
import de.seven.fate.sudoku.model.CellData;
import de.seven.fate.sudoku.model.GameData;
import de.seven.fate.sudokuserver.bo.CellDataBO;
import de.seven.fate.sudokuserver.bo.GameDataBO;
import de.seven.fate.sudokuserver.converter.CellDataBo2CellDataConverter;
import de.seven.fate.sudokuserver.converter.GameData2GameDataBoConverter;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GameFacade {

    private final GameService gameService;
    private final GameData2GameDataBoConverter gameData2GameDataBoConverter;
    private final CellDataBo2CellDataConverter cellDataBo2CellDataConverter;
    private Map<String, GameData> repository = new HashMap<>();

    public GameFacade(GameService gameService,
                      GameData2GameDataBoConverter gameData2GameDataBoConverter,
                      CellDataBo2CellDataConverter cellDataBo2CellDataConverter) {
        this.gameService = gameService;
        this.gameData2GameDataBoConverter = gameData2GameDataBoConverter;
        this.cellDataBo2CellDataConverter = cellDataBo2CellDataConverter;
    }

    public GameDataBO createGame(String gameId) {

        GameData gameData = repository.computeIfAbsent(gameId, id -> gameService.start(GameLevel.EASY));

        return gameData2GameDataBoConverter.convert(gameData);
    }

    public GameDataBO solveGame(String gameId) {

        GameData gameData = getGameData(gameId);

        gameService.solve(gameData);

        return gameData2GameDataBoConverter.convert(gameData);
    }

    public GameDataBO setNextStep(String gameId, CellDataBO cellDataBO) {

        GameData gameData = getGameData(gameId);

        CellData cellData = cellDataBo2CellDataConverter.convert(cellDataBO);

        try {
            gameService.setNextStep(gameData, cellData);

        } catch (InvalidValueException e) {

            GameDataBO gameDataBO = Validate.notNull(gameData2GameDataBoConverter.convert(gameData));

            gameDataBO.setMessage("Unable to apply value: " + cellDataBO.getValue() + " on cell with row-index: " + cellDataBO.getRowIndex() + " and col-index: " + cellDataBO.getColumnIndex());

            return gameDataBO;
        }

        return gameData2GameDataBoConverter.convert(gameData);
    }

    private GameData getGameData(String gameId) {

        return Validate.notNull(getGameData(gameId));
    }
}
