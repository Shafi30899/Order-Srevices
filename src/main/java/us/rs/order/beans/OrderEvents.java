package us.rs.order.beans;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
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


    @Id
   // @ManyToOne
  //  @JoinColumn(name = "frId",nullable = false)
    private String frId;
    private long id;
    private Date createTimeStamp;
    private Date updateTimeStamp;
    private String createdBy;
    private String updatedBy;
    private String eventName;
    private String eventDescription;




}
