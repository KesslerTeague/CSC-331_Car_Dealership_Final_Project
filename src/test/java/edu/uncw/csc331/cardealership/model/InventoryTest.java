package edu.uncw.csc331.cardealership.model;

import edu.uncw.csc331.cardealership.core.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    private Inventory inventory;
    private Car car;
    private Truck truck;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        car = new Car("V001", "Toyota", "Camry", 2020, 25000.00, 4, "Sedan");
        truck = new Truck("V002", "Ford", "F-150", 2022, 45000.00, "Crew Cab", 2000.00);
    }

    @Test
    void testAddVehicle() {
        inventory.addVehicle(car);
        assertEquals(1, inventory.viewAll().size());
    }

    @Test
    void testRemoveVehicle() {
        inventory.addVehicle(car);
        inventory.removeVehicle(car);
        assertTrue(inventory.viewAll().isEmpty());
    }

    @Test
    void testViewAll() {
        inventory.addVehicle(car);
        inventory.addVehicle(truck);
        assertEquals(2, inventory.viewAll().size());
    }

    @Test
    void testSearchByMake() {
        inventory.addVehicle(car);
        inventory.addVehicle(truck);
        List<Vehicle> results = inventory.searchByMake("Toyota");
        assertEquals(1, results.size());
        assertEquals("Toyota", results.get(0).getMake());
    }

    @Test
    void testFilterByStatus() {
        inventory.addVehicle(car);
        inventory.addVehicle(truck);
        truck.updateStatus(VehicleStatus.SOLD);
        List<Vehicle> available = inventory.filterByStatus(VehicleStatus.AVAILABLE);
        assertEquals(1, available.size());
        assertEquals("V001", available.get(0).getVehicleId());
    }

    @Test
    void testUpdateVehicle() {
        inventory.addVehicle(car);
        Car updated = new Car("V001", "Toyota", "Camry", 2020, 27000.00, 4, "Sedan");
        inventory.updateVehicle(updated);
        assertEquals(27000.00, inventory.viewAll().get(0).getPrice());
    }

    @Test
    void testRecordSale() {
        inventory.addVehicle(car);
        Sale sale = new Sale("S001", LocalDate.now(), car, "John Doe");
        inventory.recordSale(sale);
        assertEquals(VehicleStatus.SOLD, car.getStatus());
    }

    @Test
    void testGetSales() {
        inventory.addVehicle(car);
        Sale sale = new Sale("S001", LocalDate.now(), car, "John Doe");
        inventory.recordSale(sale);
        assertEquals(1, inventory.getSales().size());
        assertEquals("S001", inventory.getSales().get(0).getSaleId());
    }

    @Test
    void testFilterByType() {}

    @Test
    void testFilterByMaxPrice() {}

    @Test
    void testSearchByYear() {}

    @Test
    void testSaveToFile() {}

    @Test
    void testLoadFromFile() {}
}
