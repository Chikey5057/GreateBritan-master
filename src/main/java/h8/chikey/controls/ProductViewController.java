package h8.chikey.controls;

import h8.chikey.dao.DAO;
import h8.chikey.model.Product;
import h8.chikey.service.ServiceProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;


public class ProductViewController {
        private SessionFactory factory;
        @FXML
    public TextField txtSearch;



        @FXML
        private FlowPane flowPane;

        ObservableList<Product> productsList = FXCollections.observableArrayList();


    public  void initialize() throws FileNotFoundException {
            intData();
            createTitles();
        }
        private  void  intData(){
            factory = new Configuration().configure().buildSessionFactory();
            DAO<Product,Integer> daoManufacturer = new ServiceProduct(factory);
            productsList = FXCollections.observableArrayList(daoManufacturer.readAll());
        }
        private  void  createTitles() throws FileNotFoundException {

            flowPane.setHgap(30);
            flowPane.setVgap(30);
            flowPane.setAlignment(Pos.CENTER_LEFT);
            flowPane.setOrientation(Orientation.HORIZONTAL);

            for (Product product: productsList) {
                System.out.println(product.getMainImagePath1());
                AnchorPane anchorPane = new AnchorPane();
                anchorPane.setPrefSize(100,100);

                ImageView imageView = new ImageView();
                FileInputStream fis = new FileInputStream(product.getMainImagePath1());
                imageView.setImage(new Image(fis));
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);




                anchorPane.getChildren().add(imageView);
                flowPane.getChildren().add(anchorPane);

            }
        }
}
