package com.ooad.explodingkittens.model.Card.strategy;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ooad.explodingkittens.model.Game.Game;

/**
 * Reflects 'Algorithm' interface according to the Strategy Design Pattern
 */
@JsonSerialize(as=PlayingBehaviour.class)
public interface PlayingBehaviour {
    void run(Game game);
}
