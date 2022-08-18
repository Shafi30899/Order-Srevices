package us.rs.order.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import us.rs.order.aop.Log;
import us.rs.order.aop.LogImplementation;
import us.rs.order.pojo.Order;

import java.util.HashMap;
import java.util.Map;



@Repository
public class OrderRepository {
  public static Map<String, Order> orders=new HashMap<>();


    @Log
    public Order add(String frIdString,Order order){//order
       return orders.put(frIdString,order);

    }
    @Log
    public void remove(String frIdString){
        orders.remove(frIdString);

    }
    @Log
    public Order get(String frIdString){
       return orders.get(frIdString);


    }



}

