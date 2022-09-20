package us.rs.order.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class OrderLine implements Serializable {
//     "orderLines": [
//    {
//        "id": "<long>",
//            "createdTimeStamp": "<dateTime>",
//            "updatedTimeStamp": "<dateTime>",
//            "createdBy": "<string>",
//            "updatedBy": "<string>",
//            "lineNumber": "<integer>",
//            "frLineId": "<integer>",
//            "lineStatus": "<string>",
//            "sku": "<integer>",
//            "carrier": "<string>",
//            "shipMode": "<string>",
//            "sourceFacility": "<integer>",
//            "orderedQuantity": "<integer>",
//            "shippedQuantity": "<integer>",
//            "invoicedQuantity": "<integer>",
//            "cancelledQuantity": "<integer>",
//            "availableQuantity": "<integer>",
//            "attributes": "<object>",
//            "frId": "<string>",
//            "isCancelable": "<boolean>",
//            "cancelTimestamp": "<dateTime>",
//            "cancelReason": "<string>",
//            "packages":
//      ]
//    }
//  ],


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String createdBy;
    private String updatedBy;
    private int lineNumber;
    private int frLineId;
    private String lineStatus;
//    @ManyToOne
//    @JsonIgnore
//    @JoinTable(name = "Item_OrderLine",joinColumns = @JoinColumn(name = "id_Orderline"),referencedColumnName = "id" inverseJoinColumns =@JoinColumn(name = "Id_item",referencedColumnName = "itemId") )


    private String carrier;
    private String shipMode;
    private int sourceFacility;
    private int orderedQuantity;
    private int shippedQuantity;
    private int invoicedQuantity;
    private int cancelledQuantity;
    private int availableQuantity;

    private boolean isCancelable;
    private String cancelTimeStamp;
    private String cancelReason;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    @JoinColumn(name = "orderid", referencedColumnName = "id")
    private Order orders;


    @OneToMany(
            mappedBy = "orderLines",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Packages> packages;
    @ManyToOne(cascade = {CascadeType.MERGE})
//    @JoinTable(name = "Item_OrderLine",joinColumns ={@JoinColumn(name = "id")},
//            inverseJoinColumns ={@JoinColumn(name = "orderLineList")})
    @JoinColumn(name = "itemid", referencedColumnName = "id")
    private Item item;



    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", lineNumber=" + lineNumber +
                ", frLineId=" + frLineId +
                ", lineStatus=" + lineStatus +
                ", item" + item +

                ", carrier='" + carrier + '\'' +
                ", shipMode='" + shipMode + '\'' +
                ", sourceFacility=" + sourceFacility +
                ", orderedQuantity=" + orderedQuantity +
                ", shippedQuantity=" + shippedQuantity +
                ", invoicedQuantity=" + invoicedQuantity +
                ", cancelledQuantity=" + cancelledQuantity +
                ", availableQuantity=" + availableQuantity +
                ", isCancelable=" + isCancelable +
                ", cancelTimeStamp=" + cancelTimeStamp +
                ", cancelReason='" + cancelReason + '\'' +
                '}';
    }


    public void addReference() {
        if (this.packages != null) {
            this.packages.forEach(items ->
                    items.setOrderLines(this));

        }

    }

}
//public enum Status created Shipped cancelled