package com.singletonapps.demo.service;

import com.singletonapps.demo.dto.GameDTO;

public interface GameService {

    GameDTO createGame(GameDTO game);

    GameDTO findById(Long id);
}
