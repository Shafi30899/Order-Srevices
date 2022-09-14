package us.rs.order.beans;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Column(nullable = false)
    private String frId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String createdBy;
    private String updatedBy;
    private String orderId;
    private Integer storeNumber;
    private Status orderStatus;
    private String orderType;
    private String notes;

    @OneToMany(
            mappedBy = "orders",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<OrderAlerts> orderAlerts;

    @OneToMany(
            mappedBy = "orders",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<OrderEvents> orderEvents;
    @OneToMany(
            mappedBy = "orders",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<OrderLine> orderLine;
    public void addReference() {
        if (this.orderAlerts != null) {
            this.orderAlerts.forEach(orderAlert -> orderAlert.setOrders(this));
        }
        if (this.orderEvents != null) {
            this.orderEvents.forEach(orderEvent -> orderEvent.setOrders(this));
        }
        if (this.orderLine != null) {
            this.orderLine.forEach(orderLine ->
            {
                orderLine.addReference();
                orderLine.setOrders(this);
            });
        }

    }


    @Override
    public String toString() {
        return "Order{" +
                "frId='" + frId + '\'' +
                ", id=" + id +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", orderId='" + orderId + '\'' +
                ", storeNumber=" + storeNumber +
                ", orderStatus=" + orderStatus +
                ", orderType='" + orderType + '\'' +
                ", notes='" + notes + '\'' +
                ", orderLines=" + orderLine +
                ", orderAlerts=" + orderAlerts +
                ", orderEvents=" + orderEvents +
                '}';
    }

}
