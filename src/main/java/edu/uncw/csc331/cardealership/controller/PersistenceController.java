package edu.uncw.csc331.cardealership.controller;

import edu.uncw.csc331.cardealership.CarDealershipApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PersistenceController {

    @FXML private Label messageLabel;

    @FXML
    private void saveData() {
        CarDealershipApp.inventory.saveToFile();
        CarDealershipApp.inventory.saveSalesToFile();
        messageLabel.setStyle("-fx-text-fill: green;");
        messageLabel.setText("Vehicles and sale records saved successfully.");
    }

    @FXML
    private void loadData() {
        CarDealershipApp.inventory.loadFromFile();
        CarDealershipApp.inventory.loadSalesFromFile();
        messageLabel.setStyle("-fx-text-fill: green;");
        messageLabel.setText("Vehicles and sale records loaded successfully.");
    }
}
