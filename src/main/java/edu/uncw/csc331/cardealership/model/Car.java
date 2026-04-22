package edu.uncw.csc331.cardealership.model;

public class Car extends Vehicle {
    private int numDoors;
    private String bodyStyle;

    public void Car(String vehicleId, String make, String model, int year, double price, int numDoors, String bodyStyle) {
        super(vehicleId, make, model, year, price,);
        this.numDoors = numDoors;
        this.bodyStyle = bodyStyle;
    }

    public String getDetails() {
        return "Vehicle ID: " + this.vehicleId + "Make: " + this.make + "Model: " + this.model + "Year: " + this.year + "Price: " + this.price + "Number of Doors: " + this.numDoors + "Body Style: " + this.bodyStyle;
    }

    public void updateStatus() {
        return;
    }

    public VehicleStatus getStatus() {
        return VehicleStatus.getStatus();
    }
}
