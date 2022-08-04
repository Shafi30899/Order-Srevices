package us.rs.order.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.rs.order.pojo.Order;
import us.rs.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order createOrder(String frId, Order order) {
        orderRepository.add(frId,order);
        return orderRepository.get(frId);

    }

    @Override
    public Order updateOrderByFrId(String frId,Order order) {
        orderRepository.add(frId,order);
        return orderRepository.get(frId);
    }

    @Override
    public Order readOrderByFrId(String frId) {
        return orderRepository.get(frId);

    }

    @Override
    public void deleteOrderByFrId(String frId) {
        orderRepository.remove(frId);

    }
}
