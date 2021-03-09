package h8.chikey.model;

import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;
import java.net.URL;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int product;
    @NonNull
    @Column(name = "Title")
    private String title;
    @NonNull
    @Column(name = "Cost")
    private Double cost;
    @NonNull
    @Column(name = "Description")
    private String description;
    @Column(name = "MainImagePath")
    private String mainImagePath;
    @NonNull
    @Column(name = "IsActive")
    private boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ManufacturerID",nullable = false)
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "product")
    Set<Product> setProduct;

    public String getMainImagePath1() {
        return "C:\\Java_42\\Chikey\\GreateBritan-master\\src\\main\\resources"+"\\"+getMainImagePath();
    }

    @Override
    public String toString() {
        return "Product{" +
                "product=" + product +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", mainImagePath='" + mainImagePath + '\'' +
                ", isActive=" + isActive +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
