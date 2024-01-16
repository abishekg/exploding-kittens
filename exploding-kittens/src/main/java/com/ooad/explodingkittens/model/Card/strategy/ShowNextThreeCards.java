package com.ooad.explodingkittens.model.Card.strategy;

import com.ooad.explodingkittens.model.Game.Game;

/**
 * Reflects 'ConcreteAlgorithm' as per the Strategy Design Pattern. Implements the 'Algorithm' interface
 * This allows to see top three cards when See The Future Card is played
 */
public class ShowNextThreeCards implements PlayingBehaviour {
    @Override
    public void run(Game game) {
        game.setPlayStyle(ShowNextThreeCards.class.getSimpleName());
    }
}
