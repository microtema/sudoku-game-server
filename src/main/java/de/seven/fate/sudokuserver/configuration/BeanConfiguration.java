package de.seven.fate.sudokuserver.configuration;

import de.seven.fate.sudoku.repository.GameRepository;
import de.seven.fate.sudoku.validator.GameValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public GameValidator gameValidator(){

        return new GameValidator();
    }

    @Bean
    public GameRepository gameRepository(GameValidator gameValidator){

        return new GameRepository(gameValidator);
    }
}
