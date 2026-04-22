package edu.uncw.csc331.cardealership.model;

public class TruckTest {

private Truck truck;

    @BeforeEach
    void setUp() {
        // Runs before EVERY test: a fresh dog object
        truck = new Truck("1", "Toyota", "Tacoma", 2021, 45000.00, "Regular Cab", 2000.00);

        @Test
        @getDetails("Test car details are set correctly")
        void testgetDetails() {
            assertEquals("Vehicle ID: 1 Make: Toyota Model: Tacoma Year: 2021, Price: 45000.00, Cab Style: Regular Cab Cargo Capacity: 2000.00");
        }

        @Test
        @updateStatus("Test status is set updated correctly")
        void testupdateStatus() {
            assertEquals();
        }

        @Test
        @VehicleStatus("Test vehicle status is set correctly")
        void testVehicleStatus() {
            assertEquals(truck.getStatus());
        }
}
