package us.rs.order.beans;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import us.rs.order.pojo.OrderAlerts;
import us.rs.order.pojo.Status;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order{



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



    @Id
    private String frId;
    private long id;
    private Date createTimeStamp;
    private Date updateTimeStamp;
    private String createdBy;
    private String updatedBy;
    private String orderId;
    private Integer storeNumber;
    private Status orderStatus;
    private String orderType;
    private String notes;

//    @OneToMany
//    private List<OrderLine> orderLines=new ArrayList<>();
//    @Getter
//    @Setter
//   // @OneToMany(mappedBy = "order")
//    List<OrderEvents> orderEvents;
//    @Getter
//    @Setter
// //   @OneToMany(mappedBy = "order")
//  //  List<OrderAlerts> orderAlerts;

//
//    public String getFrId() {
//        return frId;
//    }
//
//    public void setFrId(String frId) {
//        this.frId = frId;
//    }

    @OneToMany(targetEntity = OrderLine.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "frId",referencedColumnName = "frId")
    private List<OrderLine> orderLines;

    @OneToMany(targetEntity = OrderEvents.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "frId",referencedColumnName = "frId")
    private List<OrderEvents> orderEvents;

    @OneToMany(targetEntity = us.rs.order.beans.OrderAlerts.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "frId",referencedColumnName = "frId")
    private List<OrderAlerts> orderAlerts;
}
