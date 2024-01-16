package com.ooad.explodingkittens.service;

import com.ooad.explodingkittens.command.*;
import com.ooad.explodingkittens.model.Card.*;
import com.ooad.explodingkittens.model.Card.factory.CardEnum;
import com.ooad.explodingkittens.model.DefuseCardRequestModel;
import com.ooad.explodingkittens.model.Game.Game;
import com.ooad.explodingkittens.model.Player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Reflects Singleton Design Pattern
 */
@Service
public class WebSocketService {

    @Autowired
    GameService gameService;

    public void runCardCommand(Card cardPlayed) {
        Game game = gameService.getGame();
        Invoker invoker;
        switch (cardPlayed.getCardType()) {
            case SKIP -> {
                SkipCommand skipCommand = new SkipCommand(game, (Skip) cardPlayed);
                invoker = new Invoker(skipCommand);
                invoker.runCommand();
                break;
            }
            case ATTACK -> {
                AttackCommand attackCommand = new AttackCommand(game, (Attack) cardPlayed);
                invoker = new Invoker(attackCommand);
                invoker.runCommand();
                break;
            }
            case EXPLODING_KITTENS -> {
                ExplodingKittensCommand explodingKittensCommand = new ExplodingKittensCommand(game, (ExplodingKitten) cardPlayed);
                invoker = new Invoker(explodingKittensCommand);
                invoker.runCommand();
                break;
            }
            case SHUFFLE -> {
                ShuffleCommand shuffleCommand = new ShuffleCommand(game, (Shuffle) cardPlayed);
                invoker = new Invoker(shuffleCommand);
                invoker.runCommand();
                break;
            }
            case STEAL_A_CARD -> {
                StealACardCommand stealACardCommand = new StealACardCommand(game, (StealACard) cardPlayed);
                invoker = new Invoker(stealACardCommand);
                invoker.runCommand();
                break;
            }
            case SEE_THE_FUTURE -> {
                SeeTheFutureCommand seeTheFutureCommand = new SeeTheFutureCommand(game, (SeeTheFuture) cardPlayed);
                invoker = new Invoker(seeTheFutureCommand);
                invoker.runCommand();
                break;
            }
            case DEFUSE -> {
                DefuseCommand defuseCommand = new DefuseCommand(game, (Defuse) cardPlayed);
                invoker = new Invoker(defuseCommand);
                invoker.runCommand();
                break;
            }
        }
    }

    public Game playCard(Player currentPlayer) {
        Game game = gameService.getGame();
        Card cardPlayed = currentPlayer.getLastCardPlayed();

        runCardCommand(cardPlayed);

        game.getDiscardedCards().add(cardPlayed);

        gameService.playTurn(currentPlayer);

        return gameService.getGame();
    }

    public Game withdrawCard(Card card) {
        Game game = gameService.getGame();

        Player activePlayer = game.getGameOperations().getActivePlayer(game);
        activePlayer.getHand().getListOfCards().add(card);

        game.getGameOperations().removeWithdrawnCard(game, card);
        game.setPlayStyle(null);
        if (card.getCardType() == CardEnum.EXPLODING_KITTENS) {
            runCardCommand(card);
        } else {
            game.getGameOperations().switchActivePlayer(game);
        }

        return game;
    }

    public Game stealACard(Card card) {
        Game game = gameService.getGame();

        Player givingPlayer = game.getGameOperations().getActivePlayer(game);
        Player receivingPlayer = game.getGameOperations().getInActivePlayer(game);

        givingPlayer.getHand().getListOfCards().remove(card);
        receivingPlayer.getHand().getListOfCards().add(card);

        game.getGameOperations().switchActivePlayer(game);
        game.setPlayStyle(null);

        return game;
    }

    public Game insertExplodingKittensCard(DefuseCardRequestModel defuseCardRequestModel) {
        Game game = gameService.getGame();

        Player givingPlayer = game.getGameOperations().getActivePlayer(game);
        givingPlayer.setLastCardPlayed(defuseCardRequestModel.getCard());

        playCard(givingPlayer);

        Card explodingKittensCard = givingPlayer.getHand().getListOfCards().stream().filter(card -> card.getCardType().equals(CardEnum.EXPLODING_KITTENS)).toList().get(0);

        if (defuseCardRequestModel.getIdx() < 5) {
            game.getDeck().add(game.getDeck().size() - defuseCardRequestModel.getIdx(), explodingKittensCard);
        } else {
            game.getDeck().add(0, explodingKittensCard);
        }

        givingPlayer.getHand().getListOfCards().remove(explodingKittensCard);

        game.getGameOperations().switchActivePlayer(game);
        game.setPlayStyle("ExplodingKittenCardInserted");

        return game;
    }

    public Game endGame() {
        Game game = gameService.getGame();

        Player winningPlayer = game.getGameOperations().getInActivePlayer(game);

        winningPlayer.setHasPlayerWon(true);
        game.setPlayStyle("EndGame");
        game.setGameOver(true);

        return game;
    }

    public Game restartGame() {
        gameService = new GameService();
        gameService.startGame();
        return gameService.getGame();
    }
}
