package com.ooad.explodingkittens.model.Player;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ooad.explodingkittens.model.Card.Attack;
import com.ooad.explodingkittens.model.Card.Card;
import com.ooad.explodingkittens.model.Hand.Hand;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Player {
    private static int count = 0;
    private int id;
    private String name;

    private Hand hand;

    private boolean shouldPlay;

    private Card lastCardPlayed;

    private boolean hasPlayerWon;

    public Player(String name, Hand hand) {
        this.id = ++this.count;
        this.name = name;
        this.hand = hand;
        this.lastCardPlayed = null;
        this.hasPlayerWon = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public boolean isShouldPlay() {
        return shouldPlay;
    }

    public void setShouldPlay(boolean shouldPlay) {
        this.shouldPlay = shouldPlay;
    }
}
