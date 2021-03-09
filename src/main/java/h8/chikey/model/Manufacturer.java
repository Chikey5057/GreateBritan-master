package h8.chikey.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int manufacturerID;
    @NonNull
    @Column(name = "Name")
    private String name;
    @NonNull
    @Column
    private Date startDate;

    @OneToMany(mappedBy = "manufacturer")
    Set<Product> setManufacture;



    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufactureID=" + manufacturerID +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
