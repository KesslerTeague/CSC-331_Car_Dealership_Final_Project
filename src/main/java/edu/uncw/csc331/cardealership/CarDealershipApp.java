package edu.uncw.csc331.cardealership;

import edu.uncw.csc331.cardealership.core.Inventory;
import edu.uncw.csc331.cardealership.model.Car;
import edu.uncw.csc331.cardealership.model.Truck;

public class CarDealershipApp {

    // Shared inventory instance — all controllers reference this
    public static final Inventory inventory = new Inventory();

    public static void main(String[] args) {
        inventory.loadFromFile();
        inventory.loadSalesFromFile();
    }
}