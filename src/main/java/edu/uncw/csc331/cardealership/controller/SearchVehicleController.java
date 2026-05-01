package edu.uncw.csc331.cardealership.controller;

import edu.uncw.csc331.cardealership.CarDealershipApp;
import edu.uncw.csc331.cardealership.model.Car;
import edu.uncw.csc331.cardealership.model.Truck;
import edu.uncw.csc331.cardealership.model.Vehicle;
import edu.uncw.csc331.cardealership.model.VehicleStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.List;

public class SearchVehicleController {

    @FXML private TextField vinSearchField;
    @FXML private TextField makeSearchField;
    @FXML private TextField yearSearchField;
    @FXML private TextField maxPriceField;
    @FXML private ComboBox<String> statusComboBox;
    @FXML private ComboBox<String> vehicleTypeComboBox;
    @FXML private ListView<String> resultListView;

    @FXML
    public void initialize() {
        statusComboBox.getItems().addAll("Available", "Sold", "Pending");
        vehicleTypeComboBox.getItems().addAll("Car", "Truck");
    }

    @FXML
    private void searchByVin() {
        String vin = vinSearchField.getText().trim();
        Vehicle v = CarDealershipApp.inventory.findById(vin);
        if (v != null) {
            display(List.of(v));
        } else {
            resultListView.setItems(FXCollections.observableArrayList("No vehicle found with VIN: " + vin));
        }
    }

    @FXML
    private void searchByMake() {
        display(CarDealershipApp.inventory.searchByMake(makeSearchField.getText().trim()));
    }

    @FXML
    private void searchByYear() {
        try {
            int year = Integer.parseInt(yearSearchField.getText().trim());
            display(CarDealershipApp.inventory.searchByYear(year));
        } catch (NumberFormatException e) {
            resultListView.setItems(FXCollections.observableArrayList("Invalid year."));
        }
    }

    @FXML
    private void searchByMaxPrice() {
        try {
            double maxPrice = Double.parseDouble(maxPriceField.getText().trim());
            display(CarDealershipApp.inventory.filterByMaxPrice(maxPrice));
        } catch (NumberFormatException e) {
            resultListView.setItems(FXCollections.observableArrayList("Invalid price."));
        }
    }

    @FXML
    private void searchByStatus() {
        String selected = statusComboBox.getValue();
        if (selected == null) return;
        VehicleStatus status = VehicleStatus.valueOf(selected.toUpperCase());
        display(CarDealershipApp.inventory.filterByStatus(status));
    }

    @FXML
    private void searchByType() {
        String selected = vehicleTypeComboBox.getValue();
        if (selected == null) return;
        Class<?> type = "Car".equals(selected) ? Car.class : Truck.class;
        display(CarDealershipApp.inventory.filterByType(type));
    }

    @FXML
    private void showAll() {
        display(CarDealershipApp.inventory.viewAll());
    }

    private void display(List<Vehicle> vehicles) {
        ObservableList<String> items = FXCollections.observableArrayList();
        if (vehicles.isEmpty()) {
            items.add("No results found.");
        } else {
            for (Vehicle v : vehicles) {
                items.add(v.getDetails());
            }
        }
        resultListView.setItems(items);
    }
}
