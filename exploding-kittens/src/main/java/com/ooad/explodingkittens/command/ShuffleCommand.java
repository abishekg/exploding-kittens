package com.ooad.explodingkittens.command;

import com.ooad.explodingkittens.model.Card.Shuffle;
import com.ooad.explodingkittens.model.Game.Game;

/**
 * Reflects ConcreteCommand in Command Design Pattern
 */
public class ShuffleCommand implements Command {

    Game game;
    Shuffle shuffle;

    public ShuffleCommand(Game game, Shuffle shuffle) {
        this.game = game;
        this.shuffle = shuffle;
    }

    @Override
    public void execute() {
        shuffle.getPlayingBehaviour().run(game);
    }
}
