package com.microservices.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CircuitBreakerHelloServiceDefault implements CircuitBreakerHelloService {
    @Override
//    @HystrixCommand(fallbackMethod = "fallbackSayHello",
//            commandProperties = {
//                @HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout", value = "2000")
//        })
    public String sayHello(String name) {
        return new RestTemplate()
                .getForObject("http://localhost:8080/greeting/{username}",
                        String.class, name);
    }
}
