package us.rs.order.pojo;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Packages {


    //            "packages": [
//        {
//            "id": "<long>",
//                "createdTimeStamp": "<dateTime>",
//                "updatedTimeStamp": "<dateTime>",
//                "createdBy": "<string>",
//                "updatedBy": "<string>",
//                "frId": "<string>",
//                "quantity": "<integer>",
//                "packageId": "<string>",
//                "shippedTimestamp": "<dateTime>",
//                "trackingNumber": "<string>",
//                "carrier": "<string>",
//                "serviceLevel": "<string>",
//                "attributes": "<object>"
//        }


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
    private String frId;
    @Getter
    @Setter
    private Integer quantity;
    @Getter
    @Setter
    private String packageId;
    @Getter
    @Setter
    private Date shippedTimeStamp;
    @Getter
    @Setter
    private String trackingNumber;
    @Getter
    @Setter
    private String carrier;
    @Getter
    @Setter
    private String serviceLevel;
    @Getter
    @Setter
    private Object attributes;

}
