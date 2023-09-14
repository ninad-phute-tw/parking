package org.tw.bootcamp;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.tw.bootcamp.exception.ParkableNotFoundException;
import org.tw.bootcamp.exception.ParkingFullException;
import org.tw.bootcamp.model.Parkable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        final Owner owner = Mockito.mock(Owner.class);
        lot.getNotificationCenter().register(owner);

        lot.park(car2);

        Mockito.verify(owner, Mockito.times(1)).notifyParkingStatus("Parking is full");
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
        final Owner owner = Mockito.mock(Owner.class);
        lot.getNotificationCenter().register(owner);

        lot.park(car1);

        Mockito.verify(owner, Mockito.times(1)).notifyParkingStatus("Parking is full");
    }

    @Test
    public void shouldReturnFalseIfParkingIsNotFull() {
        final ParkingLot lot = new ParkingLot(1);

        assertDoesNotThrow(lot::isParkingFull);
    }


    @Test
    public void shouldReturnTrueIfValetFindsAvailableSlotInAnyParkingLot() {
        final ParkingLot lot1 = new ParkingLot(5);
        final ParkingLot lot2 = new ParkingLot(6);
        final List<ParkingLot> managedLots = new ArrayList<>();
        managedLots.add(lot1);
        managedLots.add(lot2);
        final Valet valet = new Valet(managedLots);
        Parkable parkable1 = new Car();

        assertDoesNotThrow(() -> valet.park(parkable1));
    }

    @Test
    public void shouldThrowExceptionIfValetIsUnableToFindAParkingSlot() {
        final ParkingLot lot1 = new ParkingLot(1);
        final ParkingLot lot2 = new ParkingLot(1);
        lot1.park(new Car());
        lot2.park(new Car());
        final List<ParkingLot> managedLots = new ArrayList<>();
        managedLots.add(lot1);
        managedLots.add(lot2);
        final Valet valet = new Valet(managedLots);
        Parkable parkable1 = new Car();

        assertThrows(ParkingFullException.class, () -> valet.park(parkable1));
    }
}