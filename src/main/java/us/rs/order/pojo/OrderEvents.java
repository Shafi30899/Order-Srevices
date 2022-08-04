package us.rs.order.pojo;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderEvents {

//     "orderEvents": [
//    {
//        "id": "<long>",
//            "createdTimeStamp": "<dateTime>",
//            "updatedTimeStamp": "<dateTime>",
//            "createdBy": "<string>",
//            "updatedBy": "<string>",
//            "eventName": "<string>",
//            "eventDescription": "<string>"
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
    private String eventName;
    @Getter
    @Setter
    private String eventDescription;




}
