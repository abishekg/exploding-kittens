package com.ooad.explodingkittens.model.Hand;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ooad.explodingkittens.model.Card.Card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
public class Hand {

    @JsonProperty(value = "listOfCards")
    private List<Card> listOfCards;

    public Hand() {
        this.listOfCards = new ArrayList<>();
    }

    public void addCard(Card card) {
        listOfCards.add(card);
    }

    public List<Card> getListOfCards() {
        if (listOfCards == null) {
            return Collections.emptyList();
        }
        return listOfCards;
    }

    public void setListOfCards(List<Card> listOfCards) {
        this.listOfCards = listOfCards;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "listOfCards=" + listOfCards +
                '}';
    }
}
