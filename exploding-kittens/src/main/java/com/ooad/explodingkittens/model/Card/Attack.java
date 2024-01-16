package com.ooad.explodingkittens.model.Card;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.ooad.explodingkittens.model.Card.factory.CardEnum;
import com.ooad.explodingkittens.model.Card.strategy.EndsTurn;
import com.ooad.explodingkittens.model.Game.Game;

@JsonTypeName("Attack")
public class Attack extends Card {

    public static int count = 0;

    public Attack() {
        super("Attack", ++count, CardEnum.ATTACK, new EndsTurn());
    }
}
