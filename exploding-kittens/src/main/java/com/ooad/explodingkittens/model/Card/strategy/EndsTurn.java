package com.ooad.explodingkittens.model.Card.strategy;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ooad.explodingkittens.model.Game.Game;

/**
 * Reflects 'ConcreteAlgorithm' as per the Strategy Design Pattern. Implements the 'Algorithm' interface
 * the current player ends it's turn so the active player is switched
 */
public class EndsTurn implements PlayingBehaviour {

    @Override
    public void run(Game game) {
        game.getGameOperations().switchActivePlayer(game);
        game.setPlayStyle(null);
    }
}
