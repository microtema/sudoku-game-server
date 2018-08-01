package de.seven.fate.sudokuserver.repository;

import de.seven.fate.sudokuserver.entity.GameDataEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanGameRepository extends CrudRepository<GameDataEntity, Long> {
}
