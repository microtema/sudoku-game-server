package de.seven.fate.sudokuserver.service;


import de.seven.fate.sudoku.AbstractGameService;
import de.seven.fate.sudoku.model.CellData;
import de.seven.fate.sudoku.model.GameData;
import de.seven.fate.sudoku.repository.GameRepository;
import de.seven.fate.sudoku.validator.GameValidator;
import org.springframework.stereotype.Service;

@Service
public class HumanGameService extends AbstractGameService {

    public HumanGameService(GameRepository gameRepository, GameValidator gameValidator) {
        super(gameRepository, gameValidator);
    }
}
