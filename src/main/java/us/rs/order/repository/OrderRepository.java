package us.rs.order.repository;


import org.springframework.stereotype.Repository;
import us.rs.order.pojo.Order;

import java.util.Map;


@Repository
public class OrderRepository {
//    OrderRepository orderRepositoryObj=new OrderRepository();
//    Order orderObj=new Order();
//    @Getter
//    @Setter
//    private String key;
//    @Getter
//    @Setter
//    private String index;

//    @Getter
//    @Setter
//    public Map orders=new HashMap<>();
//    orders.put

//    public static map string ,order

//method add remove get


    public static Map<String, Order> orders;

    public Order add(String frIdString,Order order){//order
       return orders.put(frIdString,order);

    }
    public void remove(String frIdString){
        orders.remove(frIdString);

    }
    public Order get(String frIdString){
       return orders.get(frIdString);


    }

}

