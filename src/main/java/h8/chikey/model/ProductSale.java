package h8.chikey.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "productsale")
public class ProductSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int productSaleID;
    @NonNull
    @Column(name = "SaleDate")
    private Date saleData;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ProductID",nullable = false)
    private Product product;

    @NonNull
    @Column(name = "Quantity")
    private int quantity;
    @NonNull
    @Column(name = "ClientServiceID")
    private int clientId;

    @Override
    public String toString() {
        return "ProductSale{" +
                "productSaleID=" + productSaleID +
                ", saleData=" + saleData +
                ", product=" + product +
                ", quantity=" + quantity +
                ", clientId=" + clientId +
                '}';
    }
}
