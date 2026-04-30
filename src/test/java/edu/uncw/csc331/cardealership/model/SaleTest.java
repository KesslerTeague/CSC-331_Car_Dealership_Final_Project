package edu.uncw.csc331.cardealership.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {

    private Sale sale;
    private Car car;
    private LocalDate date;

    @BeforeEach
    void setUp() {
        car = new Car("V001", "Toyota", "Camry", 2020, 25000.00, 4, "Sedan");
        date = LocalDate.of(2024, 6, 15);
        sale = new Sale("S001", date, car, "John Doe");
    }

    @Test
    void testGetSaleId() {
        assertEquals("S001", sale.getSaleId());
    }

    @Test
    void testGetSaleDate() {
        assertEquals(date, sale.getSaleDate());
    }

    @Test
    void testGetVehicle() {
        assertEquals(car, sale.getVehicle());
    }

    @Test
    void testGetCustomer() {
        assertEquals("John Doe", sale.getCustomerName());
    }

    @Test
    void testRecordSale() {
        sale.recordSale();
        assertEquals(VehicleStatus.SOLD, car.getStatus());
    }

    @Test
    void testGetSaleDetails() {
        String details = sale.getSaleDetails();
        assertTrue(details.contains("S001"));
        assertTrue(details.contains("John Doe"));
        assertTrue(details.contains("2024-06-15"));
    }

    @Test
    void testCalculateTotal() {
        assertEquals(25000.00, sale.calculateTotal());
    }
}
