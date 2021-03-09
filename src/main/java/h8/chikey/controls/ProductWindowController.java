package h8.chikey.controls;

import h8.chikey.dao.DAO;
import h8.chikey.model.Product;

import h8.chikey.service.ServiceProduct;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.List;


public class ProductWindowController {

    @FXML
    private TableView<Product> tableProduct;

    @FXML
    private TableColumn<Product, Integer> columnId;

    @FXML
    private TableColumn<Product, String> columnTitle;

    @FXML
    private TableColumn<Product, Double> columnCost;

    @FXML
    private TableColumn<Product, String> columnDescription;

    @FXML
    private TableColumn<Product, Double> columnIsActive;

    @FXML
    private Button buttonCreate;

    @FXML
    private Button buttonRead;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonExit;

    @FXML
    private Button buttonUpDate;

    ObservableList<Product> productList = FXCollections.observableArrayList();



    @FXML
    void initialize(){
        buttonExit.setOnAction(actionEvent -> {
            buttonCreate.getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/view/MainWindow.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("Hello World");
            stage.setScene(new Scene(root));
            stage.show();
        });

        try(SessionFactory factory = new Configuration().configure().buildSessionFactory()){
            DAO<Product,Integer> productDAO = new ServiceProduct(factory);
            List<Product> listProducte = productDAO.readAll();
            productList.addAll(listProducte);

            columnId.setCellValueFactory(productIntegerCellDataFeatures -> new SimpleObjectProperty<>(productIntegerCellDataFeatures.getValue().getProduct()));
            columnTitle.setCellValueFactory(productCellDataFeatures-> new SimpleObjectProperty<>(productCellDataFeatures.getValue().getTitle()));
            columnCost.setCellValueFactory(productCellDataFeatures-> new SimpleObjectProperty<>(productCellDataFeatures.getValue().getCost()));
            columnDescription.setCellValueFactory(productCellDataFeatures-> new SimpleObjectProperty<>(productCellDataFeatures.getValue().getDescription()));
            tableProduct.setItems(productList);
        }

    }
}
