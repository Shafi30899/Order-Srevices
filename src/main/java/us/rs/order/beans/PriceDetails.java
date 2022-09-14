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
    private int priceId;
    private int retailPrice;
    private int sellingPrice;
    private int shippingCharges;

    @Override
    public String toString() {
        return "PriceDetails{" +
                "priceId=" + priceId +
                ", retailPrice=" + retailPrice +
                ", sellingPrice=" + sellingPrice +
                ", shippingCharges=" + shippingCharges +
                '}';
    }
}
