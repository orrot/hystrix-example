package com.microservices.controller;

public interface CircuitBreakerHelloService {

    String sayHello(String name);

    String sayHelloExceptionally(String name);
}
