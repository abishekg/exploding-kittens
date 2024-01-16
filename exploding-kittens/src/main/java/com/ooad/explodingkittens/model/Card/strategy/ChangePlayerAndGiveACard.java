package com.ooad.explodingkittens.model.Card.strategy;

import com.ooad.explodingkittens.model.Game.Game;

/**
 * Reflects 'ConcreteAlgorithm' as per the Strategy Design Pattern. Implements the 'Algorithm' interface
 * the current player is switched and it's card is taken by previous player
 */
public class ChangePlayerAndGiveACard implements PlayingBehaviour {
    @Override
    public void run(Game game) {
        game.getGameOperations().switchActivePlayer(game);
        game.setPlayStyle(ChangePlayerAndGiveACard.class.getSimpleName());
    }
}
