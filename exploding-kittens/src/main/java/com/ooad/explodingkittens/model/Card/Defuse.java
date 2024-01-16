package com.ooad.explodingkittens.model.Card;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.ooad.explodingkittens.model.Card.factory.CardEnum;
import com.ooad.explodingkittens.model.Card.strategy.EndsTurn;
import com.ooad.explodingkittens.model.Card.strategy.StopExplosion;
import com.ooad.explodingkittens.model.Game.Game;

@JsonTypeName("Defuse")
public class Defuse extends Card {

    public static int count = 0;

    public Defuse() {
        super("Defuse", ++count, CardEnum.DEFUSE, new StopExplosion());
    }
}
