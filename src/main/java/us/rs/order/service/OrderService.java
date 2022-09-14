package us.rs.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.rs.order.aop.Log;
import us.rs.order.aop.LoggerExecutionTime;
import us.rs.order.beans.Order;
import us.rs.order.exceptions.OrderNotFoundException;
import us.rs.order.persistence.OrderAlertDao;
import us.rs.order.persistence.OrderDao;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    public Order getOrderById(Long id) throws OrderNotFoundException{
        if(!orderDao.existsById(id)) throw new OrderNotFoundException("Order details not found");
        return orderDao.findById(id).get();

    }

    @Transactional
    @LoggerExecutionTime
    public void deleteOrderById(Long id) throws OrderNotFoundException {
        if(!orderDao.existsById(id)) throw new OrderNotFoundException("Order details not found");
        orderDao.deleteById(id);

    }

    @Transactional
  //  @Log
    public Order updateOrderById(Order order,Long id) throws OrderNotFoundException {
//        if(!orderDao.existsById(id)) throw new OrderNotFoundException("Order details not found");

        order.addReference();

        return orderDao.save(order);
    }

//    @Transactional
    public Order createOrderById(Order order){
        order.addReference();
        return orderDao.save(order);
    }

}
