package org.tw.bootcamp.exception;

public class ParkableNotFoundException extends RuntimeException {
    public ParkableNotFoundException(String message) {
        super(message);
    }
}
