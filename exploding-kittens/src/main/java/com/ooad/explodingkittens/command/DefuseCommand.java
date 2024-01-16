package com.ooad.explodingkittens.command;

import com.ooad.explodingkittens.model.Card.Defuse;
import com.ooad.explodingkittens.model.Game.Game;

/**
 * Reflects ConcreteCommand in Command Design Pattern
 */
public class DefuseCommand implements Command {
    Game game;

    Defuse defuse;

    public DefuseCommand(Game game, Defuse defuse) {
        this.game = game;
        this.defuse = defuse;
    }

    @Override
    public void execute() {
        defuse.getPlayingBehaviour().run(game);
    }
}
