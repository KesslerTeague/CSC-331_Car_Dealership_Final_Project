package edu.uncw.csc331.cardealership.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomerDirectory {

    private List<Customer> customers;

    private static final Path DATA_DIR = Path.of("data");
    private static final Path CUSTOMERS_FILE = Path.of("data", "customers.txt");

    public CustomerDirectory() {
        customers = new ArrayList<>();

        try {
            if (!Files.exists(DATA_DIR)) {
                Files.createDirectories(DATA_DIR);
            }
        }
        catch (IOException e) {
            System.out.println("Error creating data directory: " + e.getMessage());
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public List<Customer> searchByName(String name) {
        return customers.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public Customer searchByCustomerID(String customerID) {
        for (Customer c : customers) {
            if (c.getCustomerID().equals(customerID)) {
                return c;
            }
        }
        return null;
    }

    // Format: customerID, name, email
    public void saveCustomers() {
        try (Formatter fmt = new Formatter(CUSTOMERS_FILE.toFile())) {
            for (Customer c : customers) {
                fmt.format("%s,%s,%s", c.getCustomerID(), c.getName(), c.getEmail());
            }
        }
        catch (IOException e) {
            System.out.println("Error saving customers: " + e.getMessage());
        }
    }

    public void loadCustomers() {
        customers.clear();

        if (!Files.exists(CUSTOMERS_FILE)) {
            return;
        }

        try (Scanner scanner = new Scanner(CUSTOMERS_FILE.toFile())) {
            while (scanner.hasNextLine()) {
                String[] fields = scanner.nextLine().split(",");

                customers.add(new Customer(fields[0], fields[1], fields[2]));

                /* This is how it is done in the Dog code project. It is more robust, but the above one line does everything.
                String id = fields[0];
                String name = fields[1];
                String email = fields[2];

                Customer customer = new Customer(id, name, email);
                if (customer != null) {
                    customers.add(customer);
                }
                 */
            }
        }
        catch (IOException e) {
            System.out.println("Error loading customers: " + e.getMessage());
        }
    }
}
