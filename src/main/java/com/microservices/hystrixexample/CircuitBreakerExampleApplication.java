package com.microservices.hystrixexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.microservices")
//@EnableHystrix
public class CircuitBreakerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerExampleApplication.class, args);
	}

}
