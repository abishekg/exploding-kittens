package com.ooad.explodingkittens.model.Card;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.ooad.explodingkittens.model.Card.factory.CardEnum;
import com.ooad.explodingkittens.model.Card.strategy.EndsTurn;

@JsonTypeName("Skip")
public class Skip extends Card {

    public static int count = 0;

    public Skip() {
        super("Skip", ++count, CardEnum.SKIP, new EndsTurn());
    }

}
