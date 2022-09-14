package us.rs.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.rs.order.beans.OrderEvents;
import us.rs.order.exceptions.OrderNotFoundException;
import us.rs.order.persistence.OrderEventDao;

import java.util.Optional;

@Service
public class OrderEventService {

    @Autowired
    OrderEventDao orderEventsDao;


    public Optional<OrderEvents> getOrderEventsById(Long id) throws OrderNotFoundException {
        if(!orderEventsDao.existsById(id)) throw new OrderNotFoundException("Order details not found");
        return orderEventsDao.findById(id);

    }
    @Transactional
    public void deleteOrderEventsById(Long id) throws OrderNotFoundException {
        if(!orderEventsDao.existsById(id)) throw new OrderNotFoundException("Order details not found");
        orderEventsDao.deleteById(id);

    }
    @Transactional
    public OrderEvents updateOrderById(OrderEvents orderEvents,Long id) throws OrderNotFoundException {
        if(!orderEventsDao.existsById(id)) throw new OrderNotFoundException("Order details not found");
       return orderEventsDao.save(orderEvents);
    }
    @Transactional
    public OrderEvents createOrderById(OrderEvents orderEvents,Long id){
      return orderEventsDao.save(orderEvents);

    }
}
