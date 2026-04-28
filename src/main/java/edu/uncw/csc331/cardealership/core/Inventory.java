package edu.uncw.csc331.cardealership.core;

import edu.uncw.csc331.cardealership.model.Sale;
import edu.uncw.csc331.cardealership.model.Vehicle;
import edu.uncw.csc331.cardealership.model.VehicleStatus;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Sale> sales = new ArrayList<>();

    // Add a vehicle to inventory
    public void addVehicle(Vehicle v) {vehicles.add(v);}

    // Remove a vehicle from inventory
    public void removeVehicle(Vehicle v) {}

    // Search vehicles by make (e.g., Toyota)
    public List<Vehicle> searchByMake(String make) {
        List<Vehicle> results = new ArrayList<>();

        for (Vehicle v : vehicles) {
            if (v.getMake().equalsIgnoreCase(make)) {
                results.add(v);
            }
        }

        return results;
    }

    // Filter vehicles by status (AVAILABLE, SOLD, etc.)
    public List<Vehicle> filterByStatus(VehicleStatus status) { return new ArrayList<>(); }

    // Update a vehicle (simple version: replace it)
    public void updateVehicle(Vehicle v) {}

    // View all vehicles
    public List<Vehicle> viewAll() { return new ArrayList<>(vehicles); }

    // Record a sale and update vehicle status
    public void recordSale(Sale sale) {}

    // Get all sales
    public List<Sale> getSales() { return new ArrayList<>(sales); }
}
