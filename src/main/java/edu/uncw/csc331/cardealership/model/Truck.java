package edu.uncw.csc331.cardealership.model;

// Truck class extends Vehicle
public class Truck extends Vehicle {

    private String cabStyle;
    private double cargoCapacity;

    // Constructor
    public Truck(String vehicleId, String make, String model, int year, String cabStyle, double cargoCapacity) {
        super(vehicleId, make, model, year); // call parent constructor
        this.cabStyle = cabStyle;
        this.cargoCapacity = cargoCapacity;
    }

    // Returns details specific to a truck
    public String getDetails() {
        return "Vehicle ID: " + getVehicleId() +
                " Make: " + getMake() +
                " Model: " + getModel() +
                " Year: " + getYear() +
                " Cab Style: " + cabStyle +
                " Cargo Capacity: " + cargoCapacity;
    }
}