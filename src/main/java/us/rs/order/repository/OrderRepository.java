package us.rs.order.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import us.rs.order.pojo.Order;

import java.util.HashMap;
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


    Order order;

    public static Map<String, Order> orders=new HashMap<>();

    public Map<String,Order> add(String frIdString,Order order){//order
       orders.put(frIdString,order);
       return orders;

    }
    public void remove(String frIdString){
        orders.remove(frIdString);

    }
    public Order get(String frIdString){
       return orders.get(frIdString);


    }

}

