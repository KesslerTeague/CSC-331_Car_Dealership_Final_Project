package edu.uncw.csc331.cardealership.model;

// Enum for vehicle status (fixed values)
public enum VehicleStatus {
    AVAILABLE,
    SOLD,
    PENDING;

    // Makes the text look nicer in the UI
    @Override
    public String toString() {
        return switch (this) {
            case AVAILABLE -> "Available";
            case SOLD -> "Sold";
            case PENDING -> "Pending";
        };
    }
}
