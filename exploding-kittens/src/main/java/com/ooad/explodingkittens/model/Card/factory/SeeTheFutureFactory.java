package com.ooad.explodingkittens.model.Card.factory;

import com.ooad.explodingkittens.model.Card.Card;
import com.ooad.explodingkittens.model.Card.SeeTheFuture;

/**
 * Reflects ConcreteCreator extending the Creator of the Factory Design Pattern
 */
public class SeeTheFutureFactory extends CardFactory{
    @Override
    Card createCard() {
        return new SeeTheFuture();
    }
}
