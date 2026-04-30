package edu.uncw.csc331.cardealership.model;

// Truck class extends Vehicle
public class Truck extends Vehicle {

    private String cabStyle;
    private double cargoCapacity;

    // Constructor
    public Truck(String vehicleId, String make, String model, int year, double price, String cabStyle, double cargoCapacity) {
        super(vehicleId, make, model, year, price);
        this.cabStyle = cabStyle;
        this.cargoCapacity = cargoCapacity;
    }

    public String getCabStyle() { return cabStyle; }
    public double getCargoCapacity() { return cargoCapacity; }

    // Returns details specific to a truck
    @Override
    public String getDetails() {
        return "Vehicle ID: " + getVehicleId() +
                " Make: " + getMake() +
                " Model: " + getModel() +
                " Year: " + getYear() +
                " Price: $" + getPrice() +
                " Cab Style: " + cabStyle +
                " Cargo Capacity: " + cargoCapacity;
    }
}
