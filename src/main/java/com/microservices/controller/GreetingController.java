package com.microservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class GreetingController {

    @GetMapping("greeting/{name}")
    public String greet(@PathVariable String name) throws InterruptedException {

        int random = NumberUtils.generateRandomNumber(3, 7);
        Thread.sleep(random * 1_000L);
        return "Hi " + name + "!";
    }

    private String defaultGreeting(String username) {
        return "Hello User!";
    }
}
