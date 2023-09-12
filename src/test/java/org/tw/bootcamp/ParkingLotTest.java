package org.tw.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    public void shouldParkTheCarIfSlotIsFree() {
        final ParkingLot lot = new ParkingLot();
        final Car car = new Car("C1");

        assertTrue(lot.parkCar(car));
    }
}