package us.rs.order.service;

import us.rs.order.exceptions.OrderNotFoundException;
import us.rs.order.pojo.Order;

public interface OrderService {

    Order createOrder(String frId, Order order);
    Order updateOrderByFrId(String frId,Order order) throws OrderNotFoundException;
    Order getOrderByFrId(String frId) throws OrderNotFoundException;
    void deleteOrderByFrId(String frId) throws OrderNotFoundException;
}
