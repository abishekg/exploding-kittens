package com.ooad.explodingkittens.model.Card;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.ooad.explodingkittens.model.Card.factory.CardEnum;
import com.ooad.explodingkittens.model.Card.strategy.RandomizeDeck;

@JsonTypeName("Shuffle")
public class Shuffle extends Card {

    public static int count = 0;

    public Shuffle() {
        super("Shuffle", ++count, CardEnum.SHUFFLE, new RandomizeDeck());
    }
}
