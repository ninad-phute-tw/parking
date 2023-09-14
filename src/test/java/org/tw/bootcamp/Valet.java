package org.tw.bootcamp;

import org.tw.bootcamp.exception.ParkingFullException;
import org.tw.bootcamp.model.Parkable;

import java.util.ArrayList;
import java.util.List;

public class Valet {

    private final List<ParkingLot> lots;

    public Valet(List<ParkingLot> lots) {
        this.lots = lots;
    }

    public void park(Parkable parkable1) {
        boolean parked = false;
        for (ParkingLot lot : lots) {
            if(!lot.isParkingFull()) {
                lot.park(parkable1);
                parked = true;
                break;
            }
        }
        if(!parked) {
            throw new ParkingFullException("All parking lots full");
        }
    }
}
