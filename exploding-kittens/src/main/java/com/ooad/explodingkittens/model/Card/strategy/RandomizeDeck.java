package com.ooad.explodingkittens.model.Card.strategy;

import com.ooad.explodingkittens.model.Game.Game;

import java.util.Collections;

/**
 * Reflects 'ConcreteAlgorithm' as per the Strategy Design Pattern. Implements the 'Algorithm' interface
 * The Main Deck is shuffled
 */
public class RandomizeDeck implements PlayingBehaviour {
    @Override
    public void run(Game game) {
        Collections.shuffle(game.getDeck());
        game.setPlayStyle(null);
    }
}
