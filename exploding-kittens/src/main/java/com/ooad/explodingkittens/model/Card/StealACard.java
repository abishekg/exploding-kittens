package com.ooad.explodingkittens.model.Card;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.ooad.explodingkittens.model.Card.factory.CardEnum;
import com.ooad.explodingkittens.model.Card.strategy.ChangePlayerAndGiveACard;

@JsonTypeName("StealACard")
public class StealACard extends Card {

    public static int count = 0;

    public StealACard() {
        super("StealACard", ++count, CardEnum.STEAL_A_CARD, new ChangePlayerAndGiveACard());
    }
}
