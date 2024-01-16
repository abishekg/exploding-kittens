package com.ooad.explodingkittens.model.Game;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ooad.explodingkittens.model.Card.Card;
import com.ooad.explodingkittens.model.Hand.Hand;
import com.ooad.explodingkittens.model.Player.Player;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Game {
    //    @JsonProperty(value = "player")
    int currentPlayerId;
    List<Card> deck; // singleton
    List<Player> listOfPlayers;
    List<Card> discardedCards;

    String playStyle;

    @JsonIgnore
    GameOperations gameOperations;
    boolean isGameOver;

    public Game() {
        gameOperations = new GameOperations();
        listOfPlayers = new ArrayList<>();
        discardedCards = new ArrayList<>();
        deck = new ArrayList<>();
        isGameOver = false;
        this.playStyle = null;
    }


    public void startGame() {
        deck = gameOperations.createDeck();
    }

    public Game configurePlayerNames(String name1, String name2) {
        Hand[] hands = gameOperations.splitDeckBetweenPlayers(deck);

        this.listOfPlayers.add(new Player(name1, hands[0]));
        this.listOfPlayers.add(new Player(name2, hands[1]));

        gameOperations.addRemainingCardsToDeck(deck);

        this.currentPlayerId = gameOperations.decideStartingPlayer(listOfPlayers).getId();

        return this;
    }
}
