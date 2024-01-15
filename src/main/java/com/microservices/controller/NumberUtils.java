package com.microservices.controller;

public class NumberUtils {

    public static int generateRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
