package com.ooad.explodingkittens.model.Card;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.ooad.explodingkittens.model.Card.factory.CardEnum;
import com.ooad.explodingkittens.model.Card.strategy.MightExplode;
import com.ooad.explodingkittens.model.Card.strategy.PlayingBehaviour;
import com.ooad.explodingkittens.model.Game.Game;

@JsonTypeName("ExplodingKitten")
public class ExplodingKitten extends Card {

    public static int count = 0;

    public ExplodingKitten() {
        super("ExplodingKitten", ++count, CardEnum.EXPLODING_KITTENS, new MightExplode());
    }

}
