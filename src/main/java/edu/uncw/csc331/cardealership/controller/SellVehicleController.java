package edu.uncw.csc331.cardealership.controller;

import edu.uncw.csc331.cardealership.CarDealershipApp;
import edu.uncw.csc331.cardealership.model.Sale;
import edu.uncw.csc331.cardealership.model.Vehicle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class SellVehicleController {

    @FXML private TextField saleIdField;
    @FXML private TextField vinField;
    @FXML private TextField dateField;
    @FXML private TextField customerNameField;
    @FXML private Label messageLabel;

    @FXML
    private void completeSale() {
        String saleId = saleIdField.getText().trim();
        String vin = vinField.getText().trim();
        String dateText = dateField.getText().trim();
        String customerName = customerNameField.getText().trim();

        if (saleId.isEmpty() || vin.isEmpty() || dateText.isEmpty() || customerName.isEmpty()) {
            showError("Please fill in all fields.");
            return;
        }

        Vehicle vehicle = CarDealershipApp.inventory.findById(vin);
        if (vehicle == null) {
            showError("No vehicle found with VIN: " + vin);
            return;
        }

        try {
            LocalDate date = LocalDate.parse(dateText);
            Sale sale = new Sale(saleId, date, vehicle, customerName);
            CarDealershipApp.inventory.recordSale(sale);

            messageLabel.setStyle("-fx-text-fill: green;");
            messageLabel.setText("Sale completed. " + vehicle.getMake() + " " + vehicle.getModel() + " marked as SOLD.");
            clearFields();
        } catch (DateTimeParseException e) {
            showError("Invalid date format. Use YYYY-MM-DD.");
        }
    }

    @FXML
    private void clearFields() {
        saleIdField.clear();
        vinField.clear();
        dateField.clear();
        customerNameField.clear();
        messageLabel.setText("");
    }

    private void showError(String message) {
        messageLabel.setStyle("-fx-text-fill: #8b0000;");
        messageLabel.setText(message);
    }
}
