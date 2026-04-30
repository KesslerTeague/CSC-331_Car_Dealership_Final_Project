package edu.uncw.csc331.cardealership.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("1", "Toyota", "Camry", 2021, 18000.00, 4, "Sedan");
    }

    @Test
    void testGetDetails() {
        String details = car.getDetails();
        assertTrue(details.contains("Toyota"));
        assertTrue(details.contains("Camry"));
        assertTrue(details.contains("2021"));
        assertTrue(details.contains("4"));
        assertTrue(details.contains("Sedan"));
    }

    @Test
    void testDefaultStatusIsAvailable() {
        assertEquals(VehicleStatus.AVAILABLE, car.getStatus());
    }

    @Test
    void testUpdateStatus() {
        car.updateStatus(VehicleStatus.SOLD);
        assertEquals(VehicleStatus.SOLD, car.getStatus());
    }

    @Test
    void testUpdateStatusToPending() {}

    @Test
    void testGetters() {
        assertEquals("1", car.getVehicleId());
        assertEquals("Toyota", car.getMake());
        assertEquals("Camry", car.getModel());
        assertEquals(2021, car.getYear());
        assertEquals(18000.00, car.getPrice());
        assertEquals(4, car.getNumDoors());
        assertEquals("Sedan", car.getBodyStyle());
    }
}
