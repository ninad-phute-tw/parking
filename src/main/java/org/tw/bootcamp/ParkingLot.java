package org.tw.bootcamp;

import org.tw.bootcamp.exception.InvalidParkingSlotException;

public class ParkingLot {

    private final boolean[] slots;

    public ParkingLot(int capacity) {
        this.slots = new boolean[capacity];
    }

    public int park() {
        int freeSlot = getFreeSlot();
        if(freeSlot != -1) {
            slots[freeSlot] = true;
        }
        return freeSlot;
    }

    public void unpark(int slotId) {
        if(!slots[slotId])
            throw new InvalidParkingSlotException("Slot is already unoccupied");
        slots[slotId] = false;
    }
    public boolean isVehicleParked(int slotId) {
        return this.slots[slotId];
    }

    private int getFreeSlot() {
        int result = -1;
        for (int i = 0; i < slots.length; i++) {
            if(!slots[i]) {
                result = i;
                break;
            }
        }
        return result;
    }
}