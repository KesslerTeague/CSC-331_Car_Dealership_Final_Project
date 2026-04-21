package edu.uncw.csc331.cardealership.model;

public class Customer {
    private final String customerID;
    private String name;
    private String email;

    public Customer(String customerID, String name, String email) {
        this.customerID = customerID;
        this.name = name;
        this.email = email;
    }

    public String getCustomerID() { return customerID; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void updateContact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getPurchaseHistory() { return ""; }
}
