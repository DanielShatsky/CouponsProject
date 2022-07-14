package com.daniel.coupons.controllers;

import com.daniel.coupons.dto.Customer;
import com.daniel.coupons.logic.CustomersLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomersLogic customersLogic;

    @PostMapping
    public long createCustomer(@RequestBody Customer customer){
        return customersLogic.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") long customerId){
        return customersLogic.getCustomerById(customerId);
    }
}
