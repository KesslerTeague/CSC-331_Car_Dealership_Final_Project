package edu.uncw.csc331.cardealership.model;

public class Truck extends Vehicle {
  private String cabStyle;
  private double cargoCapacity;
  
  public void Truck(String vehicleId, String make, String model, int year, double price, String cabStyle, double cargoCapacity) {
      super(vehicleId, make, model, year, price);
      this.cabStyle = cabStyle;
      this.cargoCapacity = cargoCapacity;
    }

  public String getDetails() {
      return "Vehicle ID: " + this.vehicleId + "Make: " + this.make + "Model: " + this.model + "Year: " + this.year + "Price: " + this.price + "Cab Style: " + this.cabStyle + "Cargo Capacity: " + this.cargoCapacity;
    }

  public void updateStatus() {
      return;
    }

  public VehicleStatus getStatus() {
      return VehicleStatus.getStatus();
    }
}
