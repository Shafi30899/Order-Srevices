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
    private Integer lineNumber;
    private Integer frLineId;
    private Status lineStatus;
//    @ManyToOne
//    @JsonIgnore
//    @JoinTable(name = "Item_OrderLine",joinColumns = @JoinColumn(name = "id_Orderline"),referencedColumnName = "id" inverseJoinColumns =@JoinColumn(name = "Id_item",referencedColumnName = "itemId") )

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
//    @JoinTable(name = "Item_OrderLine",joinColumns ={@JoinColumn(name = "id")},
//            inverseJoinColumns ={@JoinColumn(name = "orderLineList")})
    @JoinColumn(name = "itemId")
    private Item item;
    private String carrier;
    private String shipMode;
    private Integer sourceFacility;
    private Integer orderedQuantity;
    private Integer shippedQuantity;
    private Integer invoicedQuantity;
    private Integer cancelledQuantity;
    private Integer availableQuantity;

    private boolean isCancelable;
    private Date cancelTimeStamp;
    private String cancelReason;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    @JoinColumn(name = "fr_Id", referencedColumnName = "frId")
    private Order orders;



    @OneToMany(
            mappedBy = "orderLines",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Packages> packages;


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