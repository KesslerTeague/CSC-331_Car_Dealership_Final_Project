package edu.uncw.csc331.cardealership.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;

import java.io.IOException;

public class HomeController {

    @FXML private AnchorPane contentArea;
    @FXML private Label statusLabel;

    @FXML private void showRegisterVehicle() { loadView("RegisterVehicleView.fxml", "Add Vehicle"); }
    @FXML private void showSellVehicle()     { loadView("SellVehicleView.fxml",     "Sell Vehicle"); }
    @FXML private void showSearchInventory() { loadView("SearchVehicleView.fxml",   "Search Inventory"); }
    @FXML private void showSaleHistory()     { loadView("SaleHistoryView.fxml",     "Sale History"); }
    @FXML private void showPersistence()     { loadView("PersistenceView.fxml",     "Save / Load"); }

    private void loadView(String fxmlFile, String label) {
        try {
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/edu/uncw/csc331/cardealership/view/" + fxmlFile)
            );
            Parent view = loader.load();

            // Stretch the loaded view to fill the entire center area
            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);

            contentArea.getChildren().setAll(view);
            statusLabel.setText(label);
        } catch (IOException e) {
            statusLabel.setText("Error loading view: " + e.getMessage());
        }
    }
}
