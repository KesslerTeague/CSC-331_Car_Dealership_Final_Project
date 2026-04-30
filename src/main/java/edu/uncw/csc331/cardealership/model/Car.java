package edu.uncw.csc331.cardealership.model;

// Car class extends Vehicle (inherits common fields)
public class Car extends Vehicle {

    private int numDoors;
    private String bodyStyle;

    // Constructor
    public Car(String vehicleId, String make, String model, int year, double price, int numDoors, String bodyStyle) {
        super(vehicleId, make, model, year, price);
        this.numDoors = numDoors;
        this.bodyStyle = bodyStyle;
    }

    public int getNumDoors() { return numDoors; }
    public String getBodyStyle() { return bodyStyle; }

    // Returns details specific to a car
    @Override
    public String getDetails() {
        return "Vehicle ID: " + getVehicleId() +
                " Make: " + getMake() +
                " Model: " + getModel() +
                " Year: " + getYear() +
                " Price: $" + getPrice() +
                " Doors: " + numDoors +
                " Body Style: " + bodyStyle;
    }
}
