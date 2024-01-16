package com.ooad.explodingkittens.model.Card.factory;

import com.ooad.explodingkittens.model.Card.Card;
import com.ooad.explodingkittens.model.Card.ExplodingKitten;

/**
 * Reflects ConcreteCreator extending the Creator of the Factory Design Pattern
 */
public class ExplodingKittensFactory extends CardFactory{
    @Override
    Card createCard() {
        return new ExplodingKitten();
    }
}
