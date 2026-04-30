package edu.uncw.csc331.cardealership.model;

import java.time.LocalDate;

public class Sale {
    private String saleId;
    private LocalDate saleDate;
    private double totalPrice;
    private Vehicle vehicle;
    private String customerName;

    public Sale(String saleId, LocalDate saleDate, Vehicle vehicle, String customerName) {
        this.saleId = saleId;
        this.saleDate = saleDate;
        this.vehicle = vehicle;
        this.customerName = customerName;
        this.totalPrice = vehicle.getPrice();
    }

    public String getSaleId() { return saleId; }
    public LocalDate getSaleDate() { return saleDate; }
    public double getTotalPrice() { return totalPrice; }
    public Vehicle getVehicle() { return vehicle; }
    public String getCustomerName() { return customerName; }

    // Marks the vehicle as SOLD
    public void recordSale() {
        vehicle.updateStatus(VehicleStatus.SOLD);
    }

    public String getSaleDetails() {
        return "Sale ID: " + saleId +
                " | Date: " + saleDate +
                " | Customer: " + customerName +
                " | Vehicle: " + vehicle.toString() +
                " | Total: $" + totalPrice;
    }

    public double calculateTotal() {
        return totalPrice;
    }
}
