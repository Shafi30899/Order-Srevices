package us.rs.order.pojo;

import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderAlerts {
//     "orderAlerts": [
//    {
//        "id": "<long>",
//            "createdTimeStamp": "<dateTime>",
//            "updatedTimeStamp": "<dateTime>",
//            "createdBy": "<string>",
//            "updatedBy": "<string>",
//            "alertType": "<string>",
//            "alertDescription": "<string>",
//            "isActive": "<boolean>",
//            "reProcessable": "<boolean>",
//            "frId": "<string>"
//    }
//  ]

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
    private String alertType;
    @Getter
    @Setter
    private String alertDescription;
    @Getter
    @Setter
    private boolean isActive;
    @Getter
    @Setter
    private boolean reProcessable;
    @Getter
    @Setter
    private String frId;



}
