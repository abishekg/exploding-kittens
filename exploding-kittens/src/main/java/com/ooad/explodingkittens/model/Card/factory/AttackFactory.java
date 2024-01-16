package com.ooad.explodingkittens.model.Card.factory;

import com.ooad.explodingkittens.model.Card.Attack;
import com.ooad.explodingkittens.model.Card.Card;

/**
 * Reflects ConcreteCreator extending the Creator of the Factory Design Pattern
 */
public class AttackFactory extends CardFactory {
    @Override
    Card createCard() {
        return new Attack();
    }
}
