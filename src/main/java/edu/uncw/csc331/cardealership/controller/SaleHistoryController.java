package edu.uncw.csc331.cardealership.controller;

import edu.uncw.csc331.cardealership.CarDealershipApp;
import edu.uncw.csc331.cardealership.model.Sale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class SaleHistoryController {

    @FXML private ListView<String> historyListView;

    @FXML
    public void initialize() {
        loadHistory();
    }

    @FXML
    private void loadHistory() {
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Sale sale : CarDealershipApp.inventory.getSales()) {
            items.add(sale.getSaleDetails());
        }
        if (items.isEmpty()) {
            items.add("No sales on record.");
        }
        historyListView.setItems(items);
    }
}
