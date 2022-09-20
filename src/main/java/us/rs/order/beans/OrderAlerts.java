package us.rs.order.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Getter
@Setter
@Entity
public class OrderAlerts {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "oa_gen")
//    @SequenceGenerator(name="oa_gen", sequenceName = "oa_seq",initialValue = 50,allocationSize=50)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String createdBy;
    private String updatedBy;
    private String alertType;
    private String alertDescription;
    private boolean isActive;
    private boolean reProcessable;
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JsonIgnore
//    @JoinColumn(name = "fr_Id", referencedColumnName = "frId")
//    private Order orders;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    @JoinColumn(name = "orderid", referencedColumnName = "id")
    private Order orders;
    @Override
    public String toString() {
        return "OrderAlerts{" +
                "id=" + id +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", alertType='" + alertType + '\'' +
                ", alertDescription='" + alertDescription + '\'' +
                ", isActive=" + isActive +
                ", reProcessable=" + reProcessable +
                '}';
    }

}
