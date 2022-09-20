package us.rs.order.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class PriceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int retailPrice;
    private int sellingPrice;
    private int shippingCharges;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "itemid", referencedColumnName = "id")
//    private Item item;

    @Override
    public String toString() {
        return "PriceDetails{" +
                "priceId=" + id +
                ", retailPrice=" + retailPrice +
                ", sellingPrice=" + sellingPrice +
                ", shippingCharges=" + shippingCharges +
                '}';
    }
}
