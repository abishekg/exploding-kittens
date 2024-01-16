package com.ooad.explodingkittens.model.Game;

import com.ooad.explodingkittens.model.Card.Card;
import com.ooad.explodingkittens.model.Card.factory.CardEnum;
import com.ooad.explodingkittens.model.Card.factory.CardFactory;
import com.ooad.explodingkittens.model.Hand.Hand;
import com.ooad.explodingkittens.model.Player.Player;

import java.util.*;
import java.util.stream.Collectors;

public class GameOperations {

    //    public static final int explodingKittensTotal = 1;
//    public static final int defuseTotal = 3;
    public static final int attackTotal = 3;
    public static final int skipTotal = 4;
    public static final int stealACardTotal = 4;
    public static final int seeTheFutureTotal = 4;
    public static final int shuffleTotal = 3;

    public List<Card> createDeck() {
        List<Card> cards = new ArrayList<>();

        int attackCount = 0;
        while (attackCount < attackTotal) {
            cards.add(CardFactory.getCard(CardEnum.ATTACK));
            attackCount++;
        }

        int skipCount = 0;
        while (skipCount < skipTotal) {
            cards.add(CardFactory.getCard(CardEnum.SKIP));
            skipCount++;
        }

        int stealACardCount = 0;
        while (stealACardCount < stealACardTotal) {
            cards.add(CardFactory.getCard(CardEnum.STEAL_A_CARD));
            stealACardCount++;
        }

        int seeTheFutureCount = 0;
        while (seeTheFutureCount < seeTheFutureTotal) {
            cards.add(CardFactory.getCard(CardEnum.SEE_THE_FUTURE));
            seeTheFutureCount++;
        }

        int shuffleCount = 0;
        while (shuffleCount < shuffleTotal) {
            cards.add(CardFactory.getCard(CardEnum.SHUFFLE));
            shuffleCount++;
        }

        Collections.shuffle(cards);

        return cards;
    }

    public Hand[] splitDeckBetweenPlayers(List<Card> deck) {
        Random random = new Random();
        Hand[] hands = new Hand[2];
        int count = 0;
        int totalSplit = 8;
        while (count < totalSplit) {
            if (hands[count % 2] == null) {
                hands[count % 2] = new Hand();
            }
            int randVal = random.nextInt(deck.size() - 1);
            hands[count % 2].addCard(deck.get(randVal));
            deck.remove(randVal);
            count++;
        }
        hands[0].addCard(CardFactory.getCard(CardEnum.DEFUSE));
        hands[1].addCard(CardFactory.getCard(CardEnum.DEFUSE));

        return hands;
    }

    public Player decideStartingPlayer(List<Player> listOfPlayers) {
        Random random = new Random();
        int randomIdx = random.nextInt(listOfPlayers.size());
        return listOfPlayers.get(randomIdx);
    }


    /**
     * Reflects Iterator Design Pattern
     * @param game
     * @param currentPlayer
     */
    public void removeCardFromCurrentPlayer(Game game, Player currentPlayer) {
        for (Iterator<Player> playerIterator = game.getListOfPlayers().iterator(); playerIterator.hasNext(); ) {
            Player player = playerIterator.next();
            if (player.getId() == currentPlayer.getId()) {
                for (Iterator<Card> cardIterator = player.getHand().getListOfCards().iterator(); cardIterator.hasNext(); ) {
                    Card card = cardIterator.next();
                    if (card.getId() == currentPlayer.getLastCardPlayed().getId()) {
                        cardIterator.remove();
                        break;
                    }
                }
            }
        }
    }

    public void addRemainingCardsToDeck(List<Card> deck) {
        deck.add(CardFactory.getCard(CardEnum.DEFUSE));
        deck.add(CardFactory.getCard(CardEnum.EXPLODING_KITTENS));

        Collections.shuffle(deck);
    }

    public Player getActivePlayer(Game game) {
        return game.getListOfPlayers().stream().filter(player -> player.getId() == game.getCurrentPlayerId()).toList().get(0);
    }

    public Player getInActivePlayer(Game game) {
        return game.getListOfPlayers().stream().filter(player -> player.getId() != game.getCurrentPlayerId()).toList().get(0);
    }

    public void switchActivePlayer(Game game) {
        game.setCurrentPlayerId(game.getListOfPlayers().stream().filter(player -> player.getId() != game.getCurrentPlayerId()).toList().get(0).getId());
    }

    public void removeWithdrawnCard(Game game, Card card) {
        game.getDeck().remove(game.getDeck().size() - 1);
    }
}
