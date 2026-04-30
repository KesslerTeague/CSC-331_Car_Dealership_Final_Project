package edu.uncw.csc331.cardealership.core;

import edu.uncw.csc331.cardealership.model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Sale> sales = new ArrayList<>();

    private static final Path DATA_DIR = Path.of("data");
    private static final Path INVENTORY_FILE = Path.of("data", "inventory.txt");

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public void removeVehicle(Vehicle v) {
        vehicles.remove(v);
    }

    // Replaces the vehicle with a matching vehicleId
    public void updateVehicle(Vehicle v) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getVehicleId().equals(v.getVehicleId())) {
                vehicles.set(i, v);
                return;
            }
        }
    }

    public List<Vehicle> viewAll() {
        return new ArrayList<>(vehicles);
    }

    public List<Vehicle> searchByMake(String make) {
        return vehicles.stream()
                .filter(v -> v.getMake().equalsIgnoreCase(make))
                .collect(Collectors.toList());
    }

    public List<Vehicle> searchByYear(int year) {
        return vehicles.stream()
                .filter(v -> v.getYear() == year)
                .collect(Collectors.toList());
    }

    // Returns vehicles priced at or under maxPrice
    public List<Vehicle> filterByMaxPrice(double maxPrice) {
        return vehicles.stream()
                .filter(v -> v.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public List<Vehicle> filterByStatus(VehicleStatus status) {
        return vehicles.stream()
                .filter(v -> v.getStatus() == status)
                .collect(Collectors.toList());
    }

    // Pass Car.class or Truck.class to filter by vehicle type
    public List<Vehicle> filterByType(Class<?> type) {
        return vehicles.stream()
                .filter(v -> v.getClass() == type)
                .collect(Collectors.toList());
    }

    // Records the sale and marks the vehicle as SOLD
    public void recordSale(Sale sale) {
        sale.recordSale();
        sales.add(sale);
    }

    public List<Sale> getSales() {
        return new ArrayList<>(sales);
    }

    // Save all vehicles to file.
    // Format per line: TYPE,vehicleId,make,model,year,price,status,[type-specific fields]
    //   Car:   CAR,vehicleId,make,model,year,price,status,numDoors,bodyStyle
    //   Truck: TRUCK,vehicleId,make,model,year,price,status,cabStyle,cargoCapacity
    public void saveToFile() {
        try {
            if (!Files.exists(DATA_DIR)) {
                Files.createDirectories(DATA_DIR);
            }
            try (PrintWriter writer = new PrintWriter(INVENTORY_FILE.toFile())) {
                for (Vehicle v : vehicles) {
                    if (v instanceof Car car) {
                        writer.printf("CAR,%s,%s,%s,%d,%.2f,%s,%d,%s%n",
                                car.getVehicleId(), car.getMake(), car.getModel(),
                                car.getYear(), car.getPrice(), car.getStatus(),
                                car.getNumDoors(), car.getBodyStyle());
                    } else if (v instanceof Truck truck) {
                        writer.printf("TRUCK,%s,%s,%s,%d,%.2f,%s,%s,%.2f%n",
                                truck.getVehicleId(), truck.getMake(), truck.getModel(),
                                truck.getYear(), truck.getPrice(), truck.getStatus(),
                                truck.getCabStyle(), truck.getCargoCapacity());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    // Load vehicles from file; replaces current in-memory inventory.
    // Expects the same format written by saveToFile().
    public void loadFromFile() {
        vehicles.clear();

        if (!Files.exists(INVENTORY_FILE)) {
            return;
        }

        try (Scanner scanner = new Scanner(INVENTORY_FILE.toFile())) {
            while (scanner.hasNextLine()) {
                String[] f = scanner.nextLine().split(",");
                if (f[0].equals("CAR")) {
                    Car car = new Car(f[1], f[2], f[3], Integer.parseInt(f[4]),
                            Double.parseDouble(f[5]), Integer.parseInt(f[7]), f[8]);
                    car.updateStatus(VehicleStatus.valueOf(f[6]));
                    vehicles.add(car);
                } else if (f[0].equals("TRUCK")) {
                    Truck truck = new Truck(f[1], f[2], f[3], Integer.parseInt(f[4]),
                            Double.parseDouble(f[5]), f[7], Double.parseDouble(f[8]));
                    truck.updateStatus(VehicleStatus.valueOf(f[6]));
                    vehicles.add(truck);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }
}
