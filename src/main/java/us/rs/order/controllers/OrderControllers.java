package us.rs.order.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import us.rs.order.aop.LoggerExecutionTime;
import us.rs.order.exceptions.OrderNotFoundException;
import us.rs.order.pojo.Order;
import us.rs.order.service.OrderService;
import us.rs.order.service.OrderServiceImpl;

@RestController
public class OrderControllers {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @PostMapping(value="/orders/{frId}")
    public Order addingOrder(@PathVariable String frId, @RequestBody Order order){
        return orderServiceImpl.createOrder(frId,order);
    }

    @PutMapping(value="/orders/{frId}")
    public Order updatingOrder(@PathVariable String frId, @RequestBody Order order){
        try {
            return orderService.updateOrderByFrId(frId,order);
        } catch (OrderNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(value = "/orders/{frId}")
    public void deletingOrder(@PathVariable String frId) {
        try {
            orderService.deleteOrderByFrId(frId);
        } catch (OrderNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/orders/{frId}")
    public Order searchingOrder(@PathVariable String frId){
        try {
            return orderService.getOrderByFrId(frId);
        } catch (OrderNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(path = "/hello")
    @LoggerExecutionTime
    public String hello() {
        return "hello";
    }


}
