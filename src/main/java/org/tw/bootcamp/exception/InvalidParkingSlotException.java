package org.tw.bootcamp.exception;

public class InvalidParkingSlotException extends RuntimeException {

    public InvalidParkingSlotException(String message) {
        super(message);
    }
}
