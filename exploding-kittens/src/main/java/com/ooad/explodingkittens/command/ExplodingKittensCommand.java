package com.ooad.explodingkittens.command;

import com.ooad.explodingkittens.model.Card.ExplodingKitten;
import com.ooad.explodingkittens.model.Game.Game;

/**
 * Reflects ConcreteCommand in Command Design Pattern
 */
public class ExplodingKittensCommand implements Command {
    Game game;

    ExplodingKitten explodingKitten;

    public ExplodingKittensCommand(Game game, ExplodingKitten explodingKitten) {
        this.game = game;
        this.explodingKitten = explodingKitten;
    }

    @Override
    public void execute() {
        explodingKitten.getPlayingBehaviour().run(game);
    }
}
