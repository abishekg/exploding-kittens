package com.ooad.explodingkittens.command;

import com.ooad.explodingkittens.model.Card.StealACard;
import com.ooad.explodingkittens.model.Game.Game;

/**
 * Reflects ConcreteCommand in Command Design Pattern
 */
public class StealACardCommand implements Command {

    Game game;
    StealACard stealACard;

    public StealACardCommand(Game game, StealACard stealACard) {
        this.game = game;
        this.stealACard = stealACard;
    }

    @Override
    public void execute() {
        stealACard.getPlayingBehaviour().run(game);
    }
}
