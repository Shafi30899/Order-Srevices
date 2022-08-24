package us.rs.order.beans;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
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
    private long id;
    private Date createTimeStamp;
    private Date updateTimeStamp;
    private String createdBy;
    private String updatedBy;
    private String alertType;
    private String alertDescription;
    private boolean isActive;
    private boolean reProcessable;
    @Id
  //  @ManyToOne
   // @JoinColumn(name = "frId",nullable = false)
    private String frId;
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "frId", nullable = false,referencedColumnName = "orderAlerts")
//    @ManyToOne
//    private Order ordersd;
//@convertor


}
