package org.tw.bootcamp;

public class ParkingLot {

    private int currentCapacity;

    // TODO QUERY discuss from the perspective of "unpark()" functionality in the future
    private final int totalCapacity;

    public ParkingLot(int capacity) {
        this.totalCapacity = capacity;
        this.currentCapacity = capacity;
    }

    public boolean park() {
        if(currentCapacity != 0) {
            --currentCapacity;
            return true;
        }
        return false;
    }
}