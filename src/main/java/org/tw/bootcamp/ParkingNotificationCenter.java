package org.tw.bootcamp;

import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.List;

public class ParkingNotificationCenter {

    private String message;
    private final List<Owner> owners = new ArrayList<>();

    public void register(Owner owner) {
        owners.add(owner);
    }

    public void deregister(Owner owner) {
        owners.remove(owner);
    }

    public void sendUpdate(String message) {
        this.message = message;
        for (Owner owner : owners) {
            owner.notifyParkingStatus(message);
        }
    }
}
