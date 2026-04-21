package edu.uncw.csc331.cardealership.model;

public enum VehicleStatus {
    AVAILABLE("Available"),
    SOLD("Sold"),
    PENDING("Pending");

    private final String status;

    VehicleStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}
