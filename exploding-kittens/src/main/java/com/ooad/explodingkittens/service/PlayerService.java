package com.ooad.explodingkittens.service;

import com.ooad.explodingkittens.model.Game.Game;
import com.ooad.explodingkittens.model.Player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Reflects Singleton Design Pattern
 */
@Service
public class PlayerService {

    @Autowired
    GameService gameService;

    public Game playerNames(String name1, String name2) {
        return gameService.getGame().configurePlayerNames(name1, name2);
    }
}
