package us.rs.order.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String itemName;

    private String itemDescription;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "priceid", referencedColumnName = "id")
    private PriceDetails priceDetails;


    @OneToMany(mappedBy = "item",cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<OrderLine> orderLines;


    @Override
    public String toString() {
        return "item{" +
                "itemId=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                '}';
    }

}
