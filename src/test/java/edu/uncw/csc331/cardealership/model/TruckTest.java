package edu.uncw.csc331.cardealership.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TruckTest {

    private Truck truck;

    @BeforeEach
    void setUp() {
        truck = new Truck("1", "Toyota", "Tacoma", 2021, 45000.00, "Regular Cab", 2000.00);
    }

    @Test
    void testGetDetails() {
        String details = truck.getDetails();
        assertTrue(details.contains("Toyota"));
        assertTrue(details.contains("Tacoma"));
        assertTrue(details.contains("2021"));
        assertTrue(details.contains("Regular Cab"));
        assertTrue(details.contains("2000.0"));
    }

    @Test
    void testDefaultStatusIsAvailable() {
        assertEquals(VehicleStatus.AVAILABLE, truck.getStatus());
    }

    @Test
    void testUpdateStatus() {
        truck.updateStatus(VehicleStatus.SOLD);
        assertEquals(VehicleStatus.SOLD, truck.getStatus());
    }

    @Test
    void testGetters() {
        assertEquals("1", truck.getVehicleId());
        assertEquals("Toyota", truck.getMake());
        assertEquals("Tacoma", truck.getModel());
        assertEquals(2021, truck.getYear());
        assertEquals(45000.00, truck.getPrice());
        assertEquals("Regular Cab", truck.getCabStyle());
        assertEquals(2000.00, truck.getCargoCapacity());
    }
}
