package org.tw.bootcamp;

import org.junit.jupiter.api.Test;
import org.tw.bootcamp.exception.InvalidParkingSlotException;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    public void shouldParkTheCarAndReturnValidSlotIdSlotIsFree() {
        final ParkingLot lot = new ParkingLot(5);

        lot.park();

        assertNotEquals(-1, lot.park());
    }

    @Test
    public void shouldReturnMinus1IfParkingFailed() {
        final ParkingLot lot = new ParkingLot(1);

        lot.park();

        assertEquals(-1, lot.park());
    }

    @Test
    public void shouldReturnTrueIfVehicleIsParked() {
        final ParkingLot lot = new ParkingLot(5);
        final int slotId = lot.park();
        assertTrue(lot.isVehicleParked(slotId));
    }

    @Test
    public void shouldNotThrowExceptionIfVehicleIsUnparked() {
        final ParkingLot lot = new ParkingLot(5);

        final int slotId = lot.park();

        assertDoesNotThrow(() -> lot.unpark(slotId));
    }

    @Test
    public void shouldThrowExceptionIfVehicleUnparkingFailed() {
        final ParkingLot lot = new ParkingLot(5);

        assertThrows(InvalidParkingSlotException.class, () -> lot.unpark(1));
    }
}