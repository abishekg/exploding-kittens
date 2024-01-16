package com.ooad.explodingkittens.command;

import com.ooad.explodingkittens.model.Card.Attack;
import com.ooad.explodingkittens.model.Game.Game;

/**
 * Reflects ConcreteCommand in Command Design Pattern
 */
public class AttackCommand implements Command {
    Game game;

    Attack attack;

    public AttackCommand(Game game, Attack attack) {
        this.game = game;
        this.attack = attack;
    }

    @Override
    public void execute() {
        attack.getPlayingBehaviour().run(game);
    }
}
