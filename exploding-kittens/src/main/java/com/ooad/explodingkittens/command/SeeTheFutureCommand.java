package com.ooad.explodingkittens.command;

import com.ooad.explodingkittens.model.Card.SeeTheFuture;
import com.ooad.explodingkittens.model.Game.Game;

/**
 * Reflects ConcreteCommand in Command Design Pattern
 */
public class SeeTheFutureCommand implements Command {

    Game game;

    SeeTheFuture seeTheFuture;

    public SeeTheFutureCommand(Game game, SeeTheFuture seeTheFuture) {
        this.game = game;
        this.seeTheFuture = seeTheFuture;
    }

    @Override
    public void execute() {
        System.out.println("SeeTheFutureCommand");
        seeTheFuture.getPlayingBehaviour().run(game);
    }
}
