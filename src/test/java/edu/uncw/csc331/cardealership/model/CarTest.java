package edu.uncw.csc331.cardealership.model;

public class CarTest {

  private Car car;

    @BeforeEach
    void setUp() {
        // Runs before EVERY test: a fresh dog object
        car = new Car("1", "Toyota", "Camry", 2021, 18000.00, 4, "Sedan");

        @Test
        @getDetails("Test car details are set correctly")
        void testgetDetails() {
            assertEquals("Vehicle ID: 1 Make: Toyota Model: Camry Year: 2021, Price: 18000.00, Number of Doors: 4 Body Style: Sedan");
        }

        @Test
        @updateStatus("Test status is set updated correctly")
        void testupdateStatus() {
            assertEquals();
        }

        @Test
        @VehicleStatus("Test vehicle status is set correctly")
        void testVehicleStatus() {
            assertEquals(car.getStatus());
        }
}
