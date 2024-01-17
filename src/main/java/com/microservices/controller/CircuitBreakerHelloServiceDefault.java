package com.microservices.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CircuitBreakerHelloServiceDefault implements CircuitBreakerHelloService {
    @Override
    public String sayHello(String name) {
        return new RestTemplate()
                .getForObject("http://localhost:8080/greeting/{username}",
                        String.class, name);
    }

    public String sayHelloExceptionally(String name) {
        return new RestTemplate()
                .getForObject("http://localhost:8080/greeting-with-fails/{username}",
                        String.class, name);
    }
}
