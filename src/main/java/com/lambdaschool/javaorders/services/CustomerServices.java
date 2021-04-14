package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;

import java.util.List;

public interface CustomerServices {


    List<Customer> findAllCustomers();
    Customer findCustomerById(long id);
    List<Customer> findCustomerByName(String custname);

}
