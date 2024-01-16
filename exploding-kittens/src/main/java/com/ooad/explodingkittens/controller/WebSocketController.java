package com.ooad.explodingkittens.controller;

import com.ooad.explodingkittens.config.TextMessageDTO;
import com.ooad.explodingkittens.model.Card.Card;
import com.ooad.explodingkittens.model.DefuseCardRequestModel;
import com.ooad.explodingkittens.model.Game.Game;
import com.ooad.explodingkittens.model.Player.Player;
import com.ooad.explodingkittens.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

    /**
     * Injects Singleton Design Pattern
     */
    @Autowired
    SimpMessagingTemplate template;

    /**
     * Injects Singleton Design Pattern
     */
    @Autowired
    WebSocketService webSocketService;

    @PostMapping("/send")
    @ResponseBody
    public ResponseEntity<Void> sendMessage(@RequestBody Player player) {
        template.convertAndSend("/topic/message", player);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @MessageMapping("/message") // /app/message
    public void receiveMessage(@Payload TextMessageDTO textMessageDTO) {
        System.out.println("Message from client -" + textMessageDTO.toString());
    }

    @MessageMapping("/play-card") // /app/playTurn
    public ResponseEntity<Void> playTurn(@Payload Player player) {
        Game game = webSocketService.playCard(player);
        template.convertAndSend("/topic/message", game);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @MessageMapping("/withdraw-card")
    public ResponseEntity<Void> withdrawCard(@Payload Card card) {
        Game game = webSocketService.withdrawCard(card);
//        webSocketService.playCard(player);
        template.convertAndSend("/topic/message", game);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @MessageMapping("/steal-a-card")
    public ResponseEntity<Void> stealACard(@Payload Card card) {
        Game game = webSocketService.stealACard(card);
        template.convertAndSend("/topic/message", game);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @MessageMapping("/insert-exploding-kitten-card")
    public ResponseEntity<Void> insertExplodingKittenCard(@Payload DefuseCardRequestModel defuseCardRequestModel) {
        System.out.println(defuseCardRequestModel);
        Game game = webSocketService.insertExplodingKittensCard(defuseCardRequestModel);
        template.convertAndSend("/topic/message", game);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @MessageMapping("/end-game")
    public ResponseEntity<Void> endGame() {
        Game game = webSocketService.endGame();
        template.convertAndSend("/topic/message", game);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @MessageMapping("/restart-game")
    public ResponseEntity<Void> restartGame() {
        Game game = webSocketService.restartGame();
        template.convertAndSend("/topic/message", game);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
