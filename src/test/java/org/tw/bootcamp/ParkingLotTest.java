package org.tw.bootcamp;

import org.junit.jupiter.api.Test;
import org.tw.bootcamp.exception.ParkableNotFoundException;
import org.tw.bootcamp.exception.ParkingFullException;
import org.tw.bootcamp.model.Parkable;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    public void shouldParkTheCarAndReturnTrueIfSlotIsFree() {
        final ParkingLot lot = new ParkingLot(5);
        final Parkable car1 = new Car();
        final Parkable car2 = new Car();

        lot.park(car1);

        assertDoesNotThrow(() -> lot.park(car2));
    }

    @Test
    public void shouldReturnFalseIfParkedBeyondCapacity() {
        final ParkingLot lot = new ParkingLot(1);
        final Parkable car2 = new Car();

        assertThrows(ParkingFullException.class,() -> lot.park(car2));
    }

    @Test
    public void shouldReturnTrueIfVehicleIsParked() {
        final ParkingLot lot = new ParkingLot(5);
        final Parkable car1 = new Car();

        lot.park(car1);

        assertTrue(lot.isParkablePresent(car1));
    }

    @Test
    public void shouldUnparkParkable() {
        final ParkingLot lot = new ParkingLot(5);
        final Parkable car1 = new Car();

        lot.park(car1);
        assertDoesNotThrow(() -> lot.unpark(car1));
    }

    @Test
    public void shouldThrowExceptionIfParkableDoesNotExistDuringUnpark() {
        final ParkingLot lot = new ParkingLot(5);
        final Parkable car1 = new Car();

        assertThrows(ParkableNotFoundException.class, () -> lot.unpark(car1));
    }

    @Test
    public void shouldNotifyWhenParkingIsFull() {
        final ParkingLot lot = new ParkingLot(1);
        final Parkable car1 = new Car();

        assertThrows(ParkingFullException.class, () -> lot.park(car1));
    }

    @Test
    public void shouldReturnFalseIfParkingIsNotFull() {
        final ParkingLot lot = new ParkingLot(1);

        assertDoesNotThrow(lot::isParkingFull);
    }
}