package org.tw.bootcamp;

import org.tw.bootcamp.exception.ParkableNotFoundException;
import org.tw.bootcamp.exception.ParkingFullException;
import org.tw.bootcamp.model.Parkable;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private final Parkable[] slots;
    private int currentCapacity;

    public ParkingLot(int capacity) {
        slots = new Parkable[capacity];
    }

    public void park(Parkable parkable) {
        int freeSlotIndex = getFreeSlot();
        if(freeSlotIndex != -1) {
            slots[freeSlotIndex] = parkable;
        } else {
            throw new ParkingFullException("No parking slot available");
        }
    }

    public boolean isParkablePresent(Parkable parkable) {
        for (Parkable slot : slots) {
            if(slot.equals(parkable)) {
                return true;
            }
        }
        return false;
    }

    public void unpark(Parkable parkable) {
        for (int i = 0; i < slots.length; i++) {
            if(slots[i] != null && slots[i].equals(parkable)) {
                slots[i] = null;
                return;
            }
        }
        throw new ParkableNotFoundException("Given Parkable is not present in the lot");
    }

    private int getFreeSlot() {
        for (int i = 0; i < slots.length; i++) {
            if(slots[i] == null) {
                return i;
            }
        }
        return -1;
    }
}