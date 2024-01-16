package com.ooad.explodingkittens.model.Card.factory;

import com.ooad.explodingkittens.model.Card.Card;

/**
 * Creating factory method class to implement Card Factory Patterns
 * Reflects Creator of the factory method
 */
public abstract class CardFactory {
    abstract Card createCard();

    public static Card getCard(CardEnum cardType) {
        CardFactory cardFactory = null;
        if (cardType.equals(CardEnum.DEFUSE)) {
            cardFactory = new DefuseFactory();
        } else if (cardType.equals(CardEnum.EXPLODING_KITTENS)) {
            cardFactory = new ExplodingKittensFactory();
        } else if (cardType.equals(CardEnum.SEE_THE_FUTURE)) {
            cardFactory = new SeeTheFutureFactory();
        } else if (cardType.equals(CardEnum.SHUFFLE)) {
            cardFactory = new ShuffleFactory();
        } else if (cardType.equals(CardEnum.SKIP)) {
            cardFactory = new SkipFactory();
        } else if (cardType.equals(CardEnum.STEAL_A_CARD)) {
            cardFactory = new StealACardFactory();
        } else if (cardType.equals(CardEnum.ATTACK)) {
            cardFactory = new AttackFactory();
        }
        return cardFactory.createCard();
    }
}
