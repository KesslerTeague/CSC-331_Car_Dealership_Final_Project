package edu.uncw.csc331.cardealership.model;

// Base class for all vehicles
public abstract class Vehicle {

    private String vehicleId;
    private String make;
    private String model;
    private int year;
    private double price;
    private VehicleStatus status;

    // Constructor (default status = AVAILABLE)
    public Vehicle(String vehicleId, String make, String model, int year, double price) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.status = VehicleStatus.AVAILABLE;
    }

    // Getters
    public String getVehicleId() { return vehicleId; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public VehicleStatus getStatus() { return status; }

    // Update status
    public void updateStatus(VehicleStatus newStatus) {
        this.status = newStatus;
    }

    // Each subclass must define its own details
    public abstract String getDetails();

    // For displaying vehicle info
    @Override
    public String toString() {
        return vehicleId + " - " + make + " " + model + " (" + year + ") $" + price + " [" + status + "]";
    }
}
