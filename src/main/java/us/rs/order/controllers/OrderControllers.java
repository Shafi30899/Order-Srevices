package us.rs.order.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.rs.order.aop.LoggerExecutionTime;
import us.rs.order.exceptions.OrderDetailsNotFoundException;
import us.rs.order.exceptions.OrderNotFoundException;
import us.rs.order.pojo.Order;
import us.rs.order.repository.OrderRepository;
import us.rs.order.service.OrderService;
import us.rs.order.service.OrderServiceImpl;

@RestController
public class OrderControllers {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderServiceImpl orderServiceImpl;

        @PostMapping(value = "/orders/{frId}")
        public Order addingOrder (@PathVariable String frId, @RequestBody Order order){
        return orderServiceImpl.createOrder(frId, order);
    }

        @PutMapping(value = "/orders/{frId}")
        public ResponseEntity<Object> updatingOrder (@PathVariable String frId, @RequestBody Order order){
         //   if(!OrderRepository.orders.containsKey(frId)) throw new OrderNotFoundException("Order Not found for Updating");
            orderService.updateOrderByFrId(frId, order);
            return new ResponseEntity<>("Order is Updated successfully", HttpStatus.OK);
    }

        @DeleteMapping(value = "/orders/{frId}")
        public ResponseEntity<Object> deletingOrder (@PathVariable String frId){
        //    if(!OrderRepository.orders.containsKey(frId)) throw new OrderNotFoundException("Order Not found for deleting");
            orderService.deleteOrderByFrId(frId);
            return new ResponseEntity<>("Order is deleted successfully", HttpStatus.OK);

    }

        @GetMapping(value = "/orders/{frId}")
        public ResponseEntity<Object> searchingOrder (@PathVariable String frId) {
        //    if(!OrderRepository.orders.containsKey(frId)) throw new OrderNotFoundException("Order  details not found");
            System.out.println(orderService.getOrderByFrId(frId));
                    return new ResponseEntity<>(" Order is available", HttpStatus.OK);
        }


        @RequestMapping(path = "/hello")
        @LoggerExecutionTime
        public String hello () {
        return "hello";
    }
    }


