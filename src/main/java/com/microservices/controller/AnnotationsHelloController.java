package com.microservices.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class AnnotationsHelloController {

    private final CircuitBreakerHelloService circuitBreakerHelloService;

    @GetMapping("hello/{name}")
    //@TimeLimiter(name = "CircuitBreakerHelloServiceDefault", fallbackMethod = "fallbackSayHello")
    @Bulkhead(name="helloService", fallbackMethod = "fallbackSayHello")
    public CompletableFuture<String> sayHello(@PathVariable String name) {
        return CompletableFuture.supplyAsync(() -> circuitBreakerHelloService.sayHello(name));
    }

    public CompletableFuture<String> fallbackSayHello(String name, Throwable throwable) {
        return CompletableFuture.supplyAsync(() -> "Sorry my dear " + name);
    }


}
