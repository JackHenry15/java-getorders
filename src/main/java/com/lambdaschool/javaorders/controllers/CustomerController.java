package com.lambdaschool.javaorders.controllers;


import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerServices customerServices;

    //http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> listAllOrders()
    {
        List<Customer> rtnList = customerServices.findAllCustomers();
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }
    //http://localhost:2019/customers/customer/7
    //http://localhost:2019/customers/customer/77
    @GetMapping(value = "/customer/{custid}", produces = "application/json")
    public ResponseEntity<?> findCustomerById(@PathVariable long custid)
    {
        Customer rtnRest = customerServices.findCustomerById(custid);
        return new ResponseEntity<>(rtnRest, HttpStatus.OK);
    }
//    //http://localhost:2019/customers/customer/77
//    @GetMapping(value = "/customer/77", produces = "application/json")
//    public ResponseEntity<?> findCustomerById()
//    {
//        List<Customer> rtnList = customerServices.findCustomerById();
//        return new ResponseEntity<>(rtnList, HttpStatus.OK);
//    }
//    //http://localhost:2019/customers/namelike/mes
//    @GetMapping(value = "/namelike/mes", produces = "application/json")
//    public ResponseEntity<?> findCustomerById()
//    {
//        List<Customer> rtnList = customerServices.findCustomerByNameLike();
//        return new ResponseEntity<>(rtnList, HttpStatus.OK);
//    }
//    //http://localhost:2019/customers/namelike/cin
//    @GetMapping(value = "/namelike/cin", produces = "application/json")
//    public ResponseEntity<?> findCustomerByNameLike()
//    {
//        List<Customer> rtnList = customerServices.findCustomerByNameLike();
//        return new ResponseEntity<>(rtnList, HttpStatus.OK);
//    }
}
