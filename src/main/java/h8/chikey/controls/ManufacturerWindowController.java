package h8.chikey.controls;

import h8.chikey.dao.DAO;
import h8.chikey.model.Manufacturer;
import h8.chikey.model.Product;
import h8.chikey.service.ServiceManufacturer;
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
import java.util.Date;
import java.util.List;

public class ManufacturerWindowController {

    @FXML
    private TableView<Manufacturer> tableManufacturer;

    @FXML
    private TableColumn<Manufacturer, Integer> columnId;

    @FXML
    private TableColumn<Manufacturer, String> columnName;

    @FXML
    private TableColumn<Manufacturer, Date> columnStartDate;

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


    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    ServiceManufacturer manufacturerDAO = new ServiceManufacturer(factory);
    ObservableList<Manufacturer> manufacturerList = FXCollections.observableArrayList();




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
        List<Manufacturer> list = manufacturerDAO.readAll();
        manufacturerList.addAll(list);

        columnId.setCellValueFactory(manufacturerIntegerCellDataFeatures -> new SimpleObjectProperty<>(manufacturerIntegerCellDataFeatures.getValue().getManufacturerID()));
        columnName.setCellValueFactory(manufacturerIntegerCellDataFeatures -> new SimpleObjectProperty<>(manufacturerIntegerCellDataFeatures.getValue().getName()));
        columnStartDate.setCellValueFactory(manufacturerIntegerCellDataFeatures -> new SimpleObjectProperty<>(manufacturerIntegerCellDataFeatures.getValue().getStartDate()));
        tableManufacturer.setItems(manufacturerList);

    }

}
