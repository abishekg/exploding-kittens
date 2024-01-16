package com.ooad.explodingkittens.model.Card;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.ooad.explodingkittens.model.Card.factory.CardEnum;
import com.ooad.explodingkittens.model.Card.strategy.ShowNextThreeCards;

@JsonTypeName("SeeTheFuture")
public class SeeTheFuture extends Card {

    public static int count = 0;

    public SeeTheFuture() {
        super("SeeTheFuture", ++count, CardEnum.SEE_THE_FUTURE, new ShowNextThreeCards());
    }
}
