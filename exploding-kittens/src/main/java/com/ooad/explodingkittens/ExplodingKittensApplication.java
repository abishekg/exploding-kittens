package com.ooad.explodingkittens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExplodingKittensApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExplodingKittensApplication.class, args);
    }
}
