package com.microservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("greeting/{name}")
    public String greet(@PathVariable String name) throws InterruptedException {

        int random = NumberUtils.generateRandomNumber(3, 7);
        Thread.sleep(random * 1_000L);
        return "Hi " + name + "!";
    }

    @GetMapping("greeting-with-fails/{name}")
    public String greetWithFails(@PathVariable String name) {

        int random = NumberUtils.generateRandomNumber(1, 3);

        if (random == 1) {
            throw new IllegalArgumentException("Error when processing " + name);
        }

        return "Hi " + name + "!";
    }
}
