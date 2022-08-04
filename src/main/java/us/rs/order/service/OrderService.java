package us.rs.order.service;

import us.rs.order.pojo.Order;

public interface OrderService {

    Order createOrder(String frId, Order order);
    Order updateOrderByFrId(String frId,Order order);
    Order readOrderByFrId(String frId);
    void deleteOrderByFrId(String frId);
}
