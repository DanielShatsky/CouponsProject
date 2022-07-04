package com.daniel.coupons.controllers;

import com.daniel.coupons.dto.Customer;
import com.daniel.coupons.logic.CustomersLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomersLogic customersLogic;

    @PostMapping
    public long createCustomer(@RequestBody Customer customer){
        return customersLogic.createCustomer(customer);
    }
}
