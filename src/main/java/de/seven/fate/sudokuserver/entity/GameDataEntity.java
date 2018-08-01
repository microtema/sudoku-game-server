package de.seven.fate.sudokuserver.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "GAME_DATA")
public class GameDataEntity {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
