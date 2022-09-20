//package us.rs.order.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import us.rs.order.beans.OrderLine;
//import us.rs.order.exceptions.OrderNotFoundException;
//import us.rs.order.persistence.OrderLineDao;
//
//import java.util.Optional;
//
//@Service
//public class OrderLineService {
//    @Autowired
//    OrderLineDao orderLineDao;
//    public Optional<OrderLine> getOrderLineById(Long id) throws OrderNotFoundException {
//        if(!orderLineDao.existsById(id)) throw new OrderNotFoundException("Order details not found");
//        return orderLineDao.findById(id);
//
//    }
//    @Transactional
//    public void deleteOrderLineById(Long id) throws OrderNotFoundException {
//        if(!orderLineDao.existsById(id)) throw new OrderNotFoundException("Order details not found");
//        orderLineDao.deleteById(id);
//    }
//    @Transactional
//    public OrderLine updateOrderLineById(OrderLine orderLine,Long id) throws OrderNotFoundException {
//        if(!orderLineDao.existsById(id)) throw new OrderNotFoundException("Order details not found");
//      //  orderLine.addReference();
//        return orderLineDao.save(orderLine);
//    }
//    @Transactional
//    public OrderLine createOrderLineById(OrderLine orderLine,Long id){
//       // orderLine.addReference();
//        return orderLineDao.save(orderLine);
//
//    }
//}
