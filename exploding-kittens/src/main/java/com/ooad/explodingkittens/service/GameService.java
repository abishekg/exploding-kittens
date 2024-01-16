package com.ooad.explodingkittens.service;

import com.ooad.explodingkittens.model.Card.Card;
import com.ooad.explodingkittens.model.Game.Game;
import com.ooad.explodingkittens.model.Player.Player;
import org.springframework.stereotype.Service;

/**
 * Reflects Singleton Design Pattern
 */
@Service
public class GameService {

    Game game;

    public String startGame() {
        game = new Game();
        game.startGame();
        return game.toString();
    }

    public Game getGame() {
        return game;
    }

    public void playTurn(Player currentPlayer) {
        game.getGameOperations().removeCardFromCurrentPlayer(game, currentPlayer);
    }
}
