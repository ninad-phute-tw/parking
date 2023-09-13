package org.tw.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    public void shouldParkTheCarAndReturnTrueIfSlotIsFree() {
        final ParkingLot lot = new ParkingLot(5);

        // TODO multiple asserts okay with single TC?
        assertTrue(lot.park());
        assertTrue(lot.park());
    }

    @Test
    public void shouldReturnFalseIfParkedBeyondCapacity() {
        final ParkingLot lot = new ParkingLot(1);

        // TODO multiple asserts okay with single TC? assertTrue(lot.park());
        lot.park();

        assertFalse(lot.park());
    }
}