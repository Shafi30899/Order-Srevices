package us.rs.order.beans;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
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


    private long id;
    private Date createTimeStamp;
    private Date updateTimeStamp;
    private String createdBy;
    private String updatedBy;
    @Id
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "frId",nullable = false)
    private String frId;
    private Integer quantity;
    private String packageId;
    private Date shippedTimeStamp;
    private String trackingNumber;
    private String carrier;
    private String serviceLevel;
//    private Object attributes;

}
