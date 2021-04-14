package com.lambdaschool.javaorders.controllers;


import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderServices orderServices;

    //http://localhost:2019/orders/order/7
    @GetMapping(value = "/order/{ordernum}", produces = "application/json")
    public ResponseEntity<?> getOrderByNumber(@PathVariable long ordernum)
    {
        Order o = orderServices.findOrdersById(ordernum);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }

}
