package com.ooad.explodingkittens.model.Card;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ooad.explodingkittens.model.Card.factory.CardEnum;
import com.ooad.explodingkittens.model.Card.strategy.PlayingBehaviour;
import com.ooad.explodingkittens.model.Game.Game;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Attack.class, name = "Attack"),
        @JsonSubTypes.Type(value = Defuse.class, name = "Defuse"),
        @JsonSubTypes.Type(value = ExplodingKitten.class, name = "ExplodingKitten"),
        @JsonSubTypes.Type(value = SeeTheFuture.class, name = "SeeTheFuture"),
        @JsonSubTypes.Type(value = Shuffle.class, name = "Shuffle"),
        @JsonSubTypes.Type(value = Skip.class, name = "Skip"),
        @JsonSubTypes.Type(value = StealACard.class, name = "StealACard")
})
public abstract class Card {
    public static int count = 0;
    private int id;
    private String name;

    CardEnum cardType;

    @JsonIgnore
    PlayingBehaviour playingBehaviour;

    public Card(String name, int count, CardEnum cardType, PlayingBehaviour playingBehaviour) {
        this.id = ++this.count;
        this.name = name + "_" + count;
        this.cardType = cardType;
        this.playingBehaviour = playingBehaviour;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cardType=" + cardType +
                ", playingBehaviour=" + playingBehaviour +
                "} \n";
    }
}
