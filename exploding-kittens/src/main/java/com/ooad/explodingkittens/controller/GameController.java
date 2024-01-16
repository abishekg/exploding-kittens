package com.ooad.explodingkittens.controller;

import com.ooad.explodingkittens.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/game")
public class GameController {

    /**
     * Injects Singleton Design Pattern
     */
    @Autowired
    GameService gameService;

    @GetMapping
    public ResponseEntity<String> getStartGame() {
        return new ResponseEntity<String>(gameService.startGame(), HttpStatus.OK);
    }

    @GetMapping("/0")
    public ResponseEntity<String> getStartedGameInstance() {
        return new ResponseEntity<String>(gameService.getGame().toString(), HttpStatus.OK);
    }
}
