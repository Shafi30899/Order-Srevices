package us.rs.order.pojo;

import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Order {



//       "id": "<long>",
//               "createdTimeStamp": "<dateTime>",
//               "updatedTimeStamp": "<dateTime>",
//               "createdBy": "<string>",
//               "updatedBy": "<string>",
//               "orderId": "<string>",
//               "frId": "<string>",
//               "storeNumber": "<integer>",
//               "orderStatus": "<string>",
//               "orderType": "<string>",
//               "notes": "<string>",


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
    private String orderId;
    @Getter
    @Setter
    private String frId;
    @Getter
    @Setter
    private Integer storeNumber;
    @Getter
    @Setter
    private Status orderStatus;
    @Getter
    @Setter
    private String orderType;
    @Getter
    @Setter
    private String notes;
    @Getter
    @Setter
    List<OrderLine> orderLines;
    @Getter
    @Setter
    List<OrderEvents> orderEvents;
    @Getter
    @Setter
    List<OrderAlerts> orderAlerts;

}
