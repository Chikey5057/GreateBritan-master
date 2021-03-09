package h8.chikey.controls;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {

    @FXML
    private Button buttonProduct;

    @FXML
    private Button buttonSale;

    @FXML
    void initialize(){
        buttonProduct.setOnAction(actionEvent -> {
            buttonProduct.getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = null;

            try {
                root = FXMLLoader.load(getClass().getResource("/view/ProductWindow.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            stage.setTitle("Hello World");
            stage.setScene(new Scene(root));
            stage.show();
        });
        buttonSale.setOnAction(actionEvent -> {
            buttonSale.getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/view/ProductWindow.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("Hello World");
            stage.setScene(new Scene(root));
            stage.show();
        });

    }
}
