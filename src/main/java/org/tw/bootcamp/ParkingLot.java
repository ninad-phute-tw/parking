package org.tw.bootcamp;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static final Map<Integer, Car> slots = new HashMap<>();

    private int currentSlot = -1;

    public boolean parkCar(Car car) {
        if(!slots.containsKey(++currentSlot)) {
            return slots.put(currentSlot, car) == null;
        }
        return false;
    }


}