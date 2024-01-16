package com.ooad.explodingkittens.model.Card.strategy;

import com.ooad.explodingkittens.model.Game.Game;

/**
 * Reflects 'ConcreteAlgorithm' as per the Strategy Design Pattern. Implements the 'Algorithm' interface
 * the current player gets the exploding Kitten card
 */
public class MightExplode implements PlayingBehaviour {
    @Override
    public void run(Game game) {
        game.setPlayStyle(MightExplode.class.getSimpleName());
    }
}
