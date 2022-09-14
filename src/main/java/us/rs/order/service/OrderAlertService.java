package us.rs.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.rs.order.beans.Order;
import us.rs.order.beans.OrderAlerts;
import us.rs.order.persistence.OrderAlertDao;

import java.util.Optional;

@Service
public class OrderAlertService {
    @Autowired
    OrderAlertDao orderAlertDao;
    public Optional<OrderAlerts> getOrderAlertsById(Long id){
        return orderAlertDao.findById(id);

    }
    @Transactional
    public void deleteOrderAlertById(Long id){
        orderAlertDao.deleteById(id);

    }
    @Transactional
    public OrderAlerts updateOrderById(OrderAlerts orderAlerts,Long id){
        return orderAlertDao.save(orderAlerts);
    }
    @Transactional
    public OrderAlerts createOrderById(OrderAlerts orderAlerts,Long id){

       return orderAlertDao.save(orderAlerts);

    }

}
