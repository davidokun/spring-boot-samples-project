package com.singletonapps.demo.exception;

public class GameNotFoundException extends RuntimeException {

    public GameNotFoundException(final String message) {
        super(message);
    }
}
