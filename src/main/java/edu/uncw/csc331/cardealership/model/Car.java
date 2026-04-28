package edu.uncw.csc331.cardealership.model;

// Car class extends Vehicle (inherits common fields)
public class Car extends Vehicle {

    private int numDoors;
    private String bodyStyle;

    // Constructor
    public Car(String vehicleId, String make, String model, int year, int numDoors, String bodyStyle) {
        super(vehicleId, make, model, year); // call parent constructor
        this.numDoors = numDoors;
        this.bodyStyle = bodyStyle;
    }

    // Returns details specific to a car
    public String getDetails() {
        return "Vehicle ID: " + getVehicleId() +
                " Make: " + getMake() +
                " Model: " + getModel() +
                " Year: " + getYear() +
                " Doors: " + numDoors +
                " Body Style: " + bodyStyle;
    }
}