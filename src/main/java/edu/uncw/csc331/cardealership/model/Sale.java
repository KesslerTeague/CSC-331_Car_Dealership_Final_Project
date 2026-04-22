package edu.uncw.csc331.cardealership.model;

import java.time.LocalDate;

public class Sale {
    private String saleId;
    private LocalDate saleDate;
    private double totalPrice;
    private Vehicle vehicle;
    private Customer customer;

    public Sale(String saleId, LocalDate saleDate, Vehicle vehicle, Customer customer) {
        this.saleId = saleId;
        this.saleDate = saleDate;
        this.vehicle = vehicle;
        this.customer = customer;
    }

    public String getSaleId() { return saleId; }
    public LocalDate getSaleDate() { return saleDate; }
    public double getTotalPrice() { return totalPrice; }
    public Vehicle getVehicle() { return vehicle; }
    public Customer getCustomer() { return customer; }

    public void recordSale() {}

    public String getSaleDetails() { return ""; }

    public double calculateTotal() { return 0; }
}
