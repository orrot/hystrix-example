package com.microservices.controller;

import io.github.resilience4j.timelimiter.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@RestController
@RequiredArgsConstructor
public class FuncionalProgrammingHelloController {

    private final CircuitBreakerHelloService circuitBreakerHelloService;

    @GetMapping("hello-fun/{name}")
    public CompletableFuture<String> sayHelloFun(@PathVariable String name) {
//        return TimeLimiter.of(Duration.ofSeconds(4L))
//                .decorateFutureSupplier(() -> CompletableFuture
//                        .supplyAsync(() -> circuitBreakerHelloService.sayHello(name)));
        return TimeLimiter.of(Duration.ofSeconds(4L))
                .executeCompletionStage(
                        Executors.newSingleThreadScheduledExecutor(),
                        () -> CompletableFuture.supplyAsync(() -> circuitBreakerHelloService.sayHello(name)))
                .toCompletableFuture();
    }
}
