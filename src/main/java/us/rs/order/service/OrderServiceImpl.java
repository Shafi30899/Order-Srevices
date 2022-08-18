package us.rs.order.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.rs.order.exceptions.OrderNotFoundException;
import us.rs.order.pojo.Order;
import us.rs.order.repository.OrderRepository;

import java.util.Map;

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
    public Order updateOrderByFrId(String frId,Order order) throws OrderNotFoundException {
        if(!OrderRepository.orders.containsKey(frId)) throw new OrderNotFoundException("Order Not found for Updating");
        orderRepository.add(frId,order);
        return orderRepository.get(frId);
    }

    @Override
    public Order getOrderByFrId(String frId) throws OrderNotFoundException {
        if (!OrderRepository.orders.containsKey(frId)) throw new OrderNotFoundException("Order  details not found");
        return orderRepository.get(frId);
    }
    @Override
        public void deleteOrderByFrId(String frId){
            if (!OrderRepository.orders.containsKey(frId)) throw new OrderNotFoundException("Order Not found for deleting");
            orderRepository.remove(frId);

        }
    }

