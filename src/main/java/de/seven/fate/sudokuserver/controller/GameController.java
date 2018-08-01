package de.seven.fate.sudokuserver.controller;

import de.seven.fate.sudokuserver.bo.CellDataBO;
import de.seven.fate.sudokuserver.facade.GameFacade;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/game", produces = MediaType.APPLICATION_JSON_VALUE)
public class GameController {

    private final GameFacade facade;

    public GameController(GameFacade facade) {
        this.facade = facade;
    }

    @GetMapping("/{id}")
    public ResponseEntity createGame(@PathVariable String id) {

        return ResponseEntity.ok(facade.createGame(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity setNextStep(@PathVariable String id, @RequestBody CellDataBO cellDataBO) {

        return ResponseEntity.ok(facade.setNextStep(id, cellDataBO));
    }

    @GetMapping("/{id}/solve")
    public ResponseEntity solveGame(@PathVariable String id) {

        return ResponseEntity.ok(facade.solveGame(id));
    }
}
