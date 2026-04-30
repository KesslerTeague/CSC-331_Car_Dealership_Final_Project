package edu.uncw.csc331.cardealership;

import edu.uncw.csc331.cardealership.core.Inventory;
import edu.uncw.csc331.cardealership.model.Car;
import edu.uncw.csc331.cardealership.model.Truck;

public class CarDealershipApp {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        // Create vehicles
        Car car1 = new Car("V001", "Toyota", "Camry", 2020, 25000.00, 4, "Sedan");
        Truck truck1 = new Truck("V002", "Ford", "F-150", 2022, 45000.00, "Crew Cab", 2000);

        // Add to inventory
        inventory.addVehicle(car1);
        inventory.addVehicle(truck1);

        // Print vehicles
        for (var v : inventory.viewAll()) {
            System.out.println(v);
            System.out.println(v.getDetails());
        }
    }
}