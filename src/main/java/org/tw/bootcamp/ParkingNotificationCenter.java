package org.tw.bootcamp;


import java.util.ArrayList;
import java.util.List;

public class ParkingNotificationCenter {

    private String message;
    private final List<ParkingNotificationListener> listeners = new ArrayList<>();

    public void register(ParkingNotificationListener listener) {
        listeners.add(listener);
    }

    public void deregister(ParkingNotificationListener listener) {
        listeners.remove(listener);
    }

    public void sendUpdate(String message) {
        this.message = message;
        for (ParkingNotificationListener listener : listeners) {
            listener.notifyParkingStatus(message);
        }
    }
}
