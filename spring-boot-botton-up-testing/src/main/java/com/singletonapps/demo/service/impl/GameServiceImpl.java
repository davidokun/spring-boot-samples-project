package com.singletonapps.demo.service.impl;

import com.singletonapps.demo.dto.GameDTO;
import com.singletonapps.demo.dto.mapper.GameMapper;
import com.singletonapps.demo.exception.GameNotFoundException;
import com.singletonapps.demo.model.Game;
import com.singletonapps.demo.repository.GameRepository;
import com.singletonapps.demo.service.GameService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public GameDTO createGame(GameDTO gameDTO) {

        LocalDateTime now = LocalDateTime.now();

        Game newGame = Game.builder()
            .name(gameDTO.getName())
            .yearPublished(gameDTO.getYearPublished())
            .createOn(now)
            .build();

        Game saved = gameRepository.save(newGame);

        return GameMapper.INSTANCE
            .gameToGameDto(saved);

    }

    @Override
    public GameDTO findById(@NotNull final Long id) {
        Optional<Game> game = gameRepository.findById(id);

        return game
            .map(GameMapper.INSTANCE::gameToGameDto)
            .orElseThrow(() -> new GameNotFoundException("Game not found"));
    }

}
