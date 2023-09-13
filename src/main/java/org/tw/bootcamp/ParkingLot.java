package org.tw.bootcamp;

import org.tw.bootcamp.model.Parkable;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private final Map<Integer, Parkable> slotMap = new HashMap<>();
    private int currentCapacity;

    private final int totalCapacity;

    public ParkingLot(int capacity) {
        this.totalCapacity = capacity;
        this.currentCapacity = capacity;
    }

    public Integer park(Parkable parkable) {
        if(currentCapacity != 0) {
            --currentCapacity;
            if(!slotMap.containsKey(currentCapacity)) {
                slotMap.put(currentCapacity, parkable);
                return currentCapacity;
            }
        }
        return -1;
    }


}