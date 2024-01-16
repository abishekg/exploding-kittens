package com.ooad.explodingkittens.command;

import com.ooad.explodingkittens.model.Card.Skip;
import com.ooad.explodingkittens.model.Game.Game;

/**
 * Reflects ConcreteCommand in Command Design Pattern
 */
public class SkipCommand implements Command {

    Game game;

    Skip skip;

    public SkipCommand(Game game, Skip skip) {
        this.game = game;
        this.skip = skip;
    }

    @Override
    public void execute() {
        skip.getPlayingBehaviour().run(game);
        System.out.println("SkipCommand");
    }
}
