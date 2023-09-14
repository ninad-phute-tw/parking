package org.tw.bootcamp;


import java.util.ArrayList;
import java.util.List;

public class ParkingNotificationCenter {

    private String message;
    private final List<ParkingLotObserver> listeners = new ArrayList<>();

    public void register(ParkingLotObserver listener) {
        listeners.add(listener);
    }

    public void deregister(ParkingLotObserver listener) {
        listeners.remove(listener);
    }

    public void sendUpdate(String message) {
        this.message = message;
        for (ParkingLotObserver listener : listeners) {
            listener.notifyParkingStatus(message);
        }
    }
}
