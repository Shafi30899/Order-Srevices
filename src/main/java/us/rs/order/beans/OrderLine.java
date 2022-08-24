package us.rs.order.beans;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class OrderLine {
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


    private long id;
    private Date createTimeStamp;
    private Date updateTimeStamp;
    private String createdBy;
    private String updatedBy;
    private Integer lineNumber;
    private Integer frLineId;
    private Status lineStatus;
    private Integer sku;
    private String carrier;
    private String shipMode;
    private Integer sourceFacility;
    private Integer orderedQuantity;
    private Integer shippedQuantity;
    private Integer invoicedQuantity;
    private Integer cancelledQuantity;
    private Integer availableQuantity;
 //   private Map<String,Object> attributes;
    @Id
 //   @ManyToOne
  //  @JoinColumn(name = "frId",nullable = false)
//    @OneToOne(fetch = FetchType.LAZY,
//            cascade =  CascadeType.ALL)
//    @ManyToOne()
    private String frId;
    private boolean isCancelable;
    private Date cancelTimeStamp;
    private String cancelReason;
    @OneToMany(targetEntity = Packages.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "frId",referencedColumnName = "frId")
    private List<Packages> packages;





}
//public enum Status created Shipped cancelled