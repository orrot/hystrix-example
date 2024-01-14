package com.microservices.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixHelloController {

    @HystrixCommand(fallbackMethod = "defaultGreeting")
    public String getGreeting(String username) {
//        return new RestTemplate()
//                .getForObject("http://localhost:9090/greeting/{username}",
//                        String.class, username);
        return "Hello World";
    }

    private String defaultGreeting(String username) {
        return "Hello User!";
    }
}
