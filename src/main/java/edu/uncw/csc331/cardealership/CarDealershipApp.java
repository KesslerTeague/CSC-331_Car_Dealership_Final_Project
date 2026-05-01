package edu.uncw.csc331.cardealership;

import edu.uncw.csc331.cardealership.core.Inventory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CarDealershipApp extends Application {

    // Shared inventory instance — all controllers reference this
    public static final Inventory inventory = new Inventory();

    @Override
    public void start(Stage stage) throws IOException {
        inventory.loadFromFile();
        inventory.loadSalesFromFile();

        Parent root = FXMLLoader.load(
            getClass().getResource("/edu/uncw/csc331/cardealership/view/HomeView.fxml")
        );
        stage.setTitle("Car Dealership Management");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
