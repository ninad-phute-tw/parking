package org.tw.bootcamp;

public class Owner {

    private String message;

    public void notifyParkingStatus(String message) {
        this.setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
