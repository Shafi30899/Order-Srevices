package us.rs.order.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.rs.order.aop.Log;
import us.rs.order.aop.LoggerExecutionTime;
import us.rs.order.beans.Order;
import us.rs.order.beans.OrderAlerts;
import us.rs.order.exceptions.OrderNotFoundException;
import us.rs.order.service.*;

import java.util.Locale;
import java.util.Optional;

@RestController
public class MyController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderAlertService orderAlertService;

//    @Autowired
//    OrderEventService orderEventService;



    @PostMapping(value = "/orders/")
    public Order addingOrder (@RequestBody Order order) throws OrderNotFoundException {
        return orderService.createOrderById(order);
    }


    @PutMapping(value = "/orders/{id}")
    public ResponseEntity<Object> updatingOrder (@PathVariable Long id, @RequestBody Order order) throws OrderNotFoundException {
        orderService.updateOrderById(order,id);
        return new ResponseEntity<>("Order is Updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/orders/{id}")
    public ResponseEntity<Object> deletingOrder (@PathVariable Long id) throws OrderNotFoundException {
        orderService.deleteOrderById(id);
        return new ResponseEntity<>("Order is deleted successfully", HttpStatus.OK);

    }

    @GetMapping(value = "/orders/{id}")
    public ResponseEntity<Object> searchingOrder (@PathVariable Long id) throws OrderNotFoundException {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/hello")
    public String getName(){
        return "Feign Demo";
    }

//    //Order Alerts
//    @PostMapping(value = "/ordersAlerts/{id}")
//    public OrderAlerts addingOrderAlerts (@PathVariable Long id, @RequestBody OrderAlerts orderAlerts) throws OrderNotFoundException {
//        return orderAlertService.createOrderById(orderAlerts,id);
//    }
//
//    @PutMapping(value = "/ordersAlerts/{id}")
//    public ResponseEntity<Object> updatingOrderAlerts (@PathVariable Long id, @RequestBody OrderAlerts orderAlerts) throws OrderNotFoundException {
//        orderAlertService.updateOrderById(orderAlerts,id);
//        return new ResponseEntity<>("OrderAlert is Updated successfully", HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = "/ordersAlerts/{id}")
//    public ResponseEntity<Object> deletingOrderAlerts (@PathVariable Long id) throws OrderNotFoundException {
//        orderAlertService.deleteOrderAlertById(id);
//        return new ResponseEntity<>("OrderAlert is deleted successfully", HttpStatus.OK);
//
//    }
//
//    @GetMapping(value = "/ordersAlerts/{id}")
//    public ResponseEntity<Object> searchingOrderAlerts (@PathVariable Long id) throws OrderNotFoundException {
//        System.out.println(orderAlertService.getOrderAlertsById(id));
//        return new ResponseEntity<>(" OrderAlert is available", HttpStatus.OK);
//    }
//
//
//
//
//


//    //Order Events
//    @PostMapping(value = "/ordersEvents/{id}")
//    public Optional<OrderEvents> addingOrderEvents (@PathVariable Long id, @RequestBody OrderEvents orderEvents) throws OrderNotFoundException {
//        return orderEventService.createOrderById(orderEvents,id);
//    }
//
//    @PutMapping(value = "/ordersEvents/{id}")
//    public ResponseEntity<Object> updatingOrderEvents (@PathVariable Long id, @RequestBody OrderEvents orderEvents) throws OrderNotFoundException {
//        orderEventService.updateOrderById(orderEvents,id);
//        return new ResponseEntity<>("OrderEvent is Updated successfully", HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = "/ordersEvents/{id}")
//    public ResponseEntity<Object> deletingOrderEvents (@PathVariable Long id) throws OrderNotFoundException {
//        orderEventService.deleteOrderEventsById(id);
//        return new ResponseEntity<>("OrderEvent is deleted successfully", HttpStatus.OK);
//
//    }
//
//    @GetMapping(value = "/ordersEvents/{id}")
//    public ResponseEntity<Object> searchingOrderEvents (@PathVariable Long id) throws OrderNotFoundException {
//        System.out.println(orderEventService.getOrderEventsById(id));
//        return new ResponseEntity<>(" OrderEvent is available", HttpStatus.OK);
//    }





}
