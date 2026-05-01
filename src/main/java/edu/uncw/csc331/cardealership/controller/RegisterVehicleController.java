package edu.uncw.csc331.cardealership.controller;

import edu.uncw.csc331.cardealership.CarDealershipApp;
import edu.uncw.csc331.cardealership.model.Car;
import edu.uncw.csc331.cardealership.model.Truck;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterVehicleController {

    @FXML private TextField vinField;
    @FXML private TextField makeField;
    @FXML private TextField modelField;
    @FXML private TextField yearField;
    @FXML private TextField priceField;
    @FXML private ComboBox<String> typeComboBox;

    @FXML private Label numDoorsLabel;
    @FXML private TextField numDoorsField;
    @FXML private Label bodyStyleLabel;
    @FXML private TextField bodyStyleField;

    @FXML private Label cabStyleLabel;
    @FXML private TextField cabStyleField;
    @FXML private Label cargoCapacityLabel;
    @FXML private TextField cargoCapacityField;

    @FXML private Label messageLabel;

    @FXML
    public void initialize() {
        typeComboBox.getItems().addAll("Car", "Truck");

        // Show/hide subclass fields when type is selected
        typeComboBox.setOnAction(e -> {
            String selected = typeComboBox.getValue();
            boolean isCar = "Car".equals(selected);
            boolean isTruck = "Truck".equals(selected);

            numDoorsLabel.setVisible(isCar);
            numDoorsField.setVisible(isCar);
            bodyStyleLabel.setVisible(isCar);
            bodyStyleField.setVisible(isCar);

            cabStyleLabel.setVisible(isTruck);
            cabStyleField.setVisible(isTruck);
            cargoCapacityLabel.setVisible(isTruck);
            cargoCapacityField.setVisible(isTruck);
        });
    }

    @FXML
    private void registerVehicle() {
        try {
            String vin = vinField.getText().trim();
            String make = makeField.getText().trim();
            String model = modelField.getText().trim();
            int year = Integer.parseInt(yearField.getText().trim());
            double price = Double.parseDouble(priceField.getText().trim());
            String type = typeComboBox.getValue();

            if (vin.isEmpty() || make.isEmpty() || model.isEmpty() || type == null) {
                messageLabel.setText("Please fill in all fields and select a type.");
                return;
            }

            if ("Car".equals(type)) {
                int numDoors = Integer.parseInt(numDoorsField.getText().trim());
                String bodyStyle = bodyStyleField.getText().trim();
                CarDealershipApp.inventory.addVehicle(new Car(vin, make, model, year, price, numDoors, bodyStyle));
            } else {
                String cabStyle = cabStyleField.getText().trim();
                double cargoCapacity = Double.parseDouble(cargoCapacityField.getText().trim());
                CarDealershipApp.inventory.addVehicle(new Truck(vin, make, model, year, price, cabStyle, cargoCapacity));
            }

            messageLabel.setStyle("-fx-text-fill: green;");
            messageLabel.setText("Vehicle registered successfully.");
            clearFields();

        } catch (NumberFormatException e) {
            messageLabel.setStyle("-fx-text-fill: #8b0000;");
            messageLabel.setText("Invalid number format. Check year, price, and type-specific fields.");
        }
    }

    @FXML
    private void clearFields() {
        vinField.clear();
        makeField.clear();
        modelField.clear();
        yearField.clear();
        priceField.clear();
        typeComboBox.setValue(null);
        numDoorsField.clear();
        bodyStyleField.clear();
        cabStyleField.clear();
        cargoCapacityField.clear();

        // Hide all subclass fields until a type is chosen again
        numDoorsLabel.setVisible(false);
        numDoorsField.setVisible(false);
        bodyStyleLabel.setVisible(false);
        bodyStyleField.setVisible(false);
        cabStyleLabel.setVisible(false);
        cabStyleField.setVisible(false);
        cargoCapacityLabel.setVisible(false);
        cargoCapacityField.setVisible(false);

        messageLabel.setText("");
    }
}
