package edu.uncw.csc331.cardealership.core;

import edu.uncw.csc331.cardealership.model.Sale;
import edu.uncw.csc331.cardealership.model.Vehicle;
import edu.uncw.csc331.cardealership.model.VehicleStatus;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Sale> sales = new ArrayList<>();

    public void addVehicle(Vehicle v) {}

    public void removeVehicle(Vehicle v) {}

    public List<Vehicle> searchByMake(String make) { return new ArrayList<>(); }

    public List<Vehicle> filterByStatus(VehicleStatus status) { return new ArrayList<>(); }

    public void updateVehicle(Vehicle v) {}

    public List<Vehicle> viewAll() { return new ArrayList<>(vehicles); }

    public void recordSale(Sale sale) {}

    public List<Sale> getSales() { return new ArrayList<>(sales); }
}
