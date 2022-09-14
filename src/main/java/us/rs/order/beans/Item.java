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
    private int itemId;
    private String itemName;
    @OneToOne(cascade = CascadeType.ALL)
    private PriceDetails price;
    private String itemDescription;


    @OneToMany(mappedBy = "item",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JsonIgnore
    private List<OrderLine> orderLineList=new ArrayList<>();


    @Override
    public String toString() {
        return "item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                '}';
    }

}
