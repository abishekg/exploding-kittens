package com.ooad.explodingkittens.controller;

import com.ooad.explodingkittens.model.Game.Game;
import com.ooad.explodingkittens.model.Player.Player;
import com.ooad.explodingkittens.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("api/v1/player")
public class PlayerController {
    /**
     * Injects Singleton Design Pattern
     */
    @Autowired
    PlayerService playerService;

    @PostMapping()
    @ResponseBody
    public ResponseEntity<Game> postPlayerNames(@RequestBody Map<String, String> payload) {
        System.out.println(Arrays.toString(payload.values().toArray()));
        ResponseEntity<Game> responseEntity = new ResponseEntity<>(playerService.playerNames(payload.get("player1Name"), payload.get("player2Name")), HttpStatus.CREATED);
        return responseEntity;
    }
}
