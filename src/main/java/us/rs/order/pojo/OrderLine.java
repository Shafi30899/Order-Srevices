package us.rs.order.pojo;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor

@ToString

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


    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private Date createTimeStamp;
    @Getter
    @Setter
    private Date updateTimeStamp;
    @Getter
    @Setter
    private String createdBy;
    @Getter
    @Setter
    private String updatedBy;
    @Getter
    @Setter
    private Integer lineNumber;
    @Getter
    @Setter
    private Integer frLineId;
    @Getter
    @Setter
    private Status lineStatus;
    @Getter
    @Setter
    private Integer sku;
    @Getter
    @Setter
    private String carrier;
    @Getter
    @Setter
    private String shipMode;
    @Getter
    @Setter
    private Integer sourceFacility;
    @Getter
    @Setter
    private Integer orderedQuantity;
    @Getter
    @Setter
    private Integer shippedQuantity;
    @Getter
    @Setter
    private Integer invoicedQuantity;
    @Getter
    @Setter
    private Integer cancelledQuantity;
    @Getter
    @Setter
    private Integer availableQuantity;
    @Getter
    @Setter
    private Map<String,Object> attributes;
    @Getter
    @Setter
    private String frId;
    @Getter
    @Setter
    private boolean isCancelable;
    @Getter
    @Setter
    private Date cancelTimeStamp;
    @Getter
    @Setter
    private String cancelReason;
    @Getter
    @Setter
    List<Packages> packages;





}
//public enum Status created Shipped cancelled