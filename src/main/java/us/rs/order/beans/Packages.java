package us.rs.order.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import us.rs.order.convertors.AttributeConvertorMap;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Getter
@Setter
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


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String createTimeStamp;
    private String updateTimeStamp;
    private String createdBy;
    private String updatedBy;
//    private String frId;
    private int quantity;
    private String packageId;
    private String shippedTimeStamp;
    private String trackingNumber;
    private String carrier;
//    @Convert(converter = AttributeConvertorMap.class)
//    private Map<String,String> attribute;
    private String attribute;
    private String serviceLevel;


    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "orderlines", referencedColumnName = "id")
    private OrderLine orderLines;

    @Override
    public String toString() {
        return "Packages{" +
                "id=" + id +
                ", createTimeStamp=" + createTimeStamp +
                ", updateTimeStamp=" + updateTimeStamp +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", quantity=" + quantity +
                ", packageId='" + packageId + '\'' +
                ", shippedTimeStamp=" + shippedTimeStamp +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", carrier='" + carrier + '\'' +
                ", Attribute='" + attribute + '\'' +
                ", serviceLevel='" + serviceLevel + '\'' +
                '}';
    }
}
