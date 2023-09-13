package org.tw.bootcamp;

import org.junit.jupiter.api.Test;
import org.tw.bootcamp.model.Car;
import org.tw.bootcamp.model.Parkable;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    public void shouldParkTheCarAndReturnTrueIfSlotIsFree() {
        final ParkingLot lot = new ParkingLot(5);
        final Parkable car1 = new Car();
        final Parkable car2 = new Car();

        lot.park(car1);

        assertNotEquals(-1, lot.park(car2));
    }

    @Test
    public void shouldReturnFalseIfParkedBeyondCapacity() {
        final ParkingLot lot = new ParkingLot(1);
        final Parkable car1 = new Car();
        final Parkable car2 = new Car();

        lot.park(car1);

        assertNotEquals(-1, lot.park(car2));
    }

    @Test
    public void shouldReturnTrueIfVehicleIsParked() {
        final ParkingLot lot = new ParkingLot(5);
        final Parkable car1 = new Car();

        final int slotId = lot.park(car1);

        assertNotEquals(-1, slotId);
    }

}