package us.rs.order.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
//@ToString
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String createdBy;
    private String updatedBy;
    private String eventName;
    private String eventDescription;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    @JoinColumn(name = "fr_Id", referencedColumnName = "frId")
    private Order orders;



    @Override
    public String toString() {
        return "OrderEvents{" +
                "id=" + id +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                '}';
    }
}
