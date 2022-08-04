package us.rs.order.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        return orderService.updateOrderByFrId(frId,order);
    }

    @DeleteMapping(value = "/orders/{frId}")
    public void deletingOrder(@PathVariable String frId){
        orderService.deleteOrderByFrId(frId);
    }

    @GetMapping(value = "/orders/{frId}")
    public Order searchingOrder(@PathVariable String frId){
        return orderService.readOrderByFrId(frId);
    }

}
