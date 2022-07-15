package com.daniel.coupons.logic;

import com.daniel.coupons.dto.Customer;
import com.daniel.coupons.dto.User;
import com.daniel.coupons.entities.CustomerEntity;
import com.daniel.coupons.enums.UserType;
import com.daniel.coupons.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomersLogic {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private UsersLogic usersLogic;

    public long createCustomer(Customer customer){
        User user = customer.getUser();
        user.setUserType(UserType.CUSTOMER);
        user.setCompanyId(null);
        CustomerEntity customersEntity = new CustomerEntity(customer);
        customerRepository.save(customersEntity);
        return customersEntity.getId();
    }

    public Customer getCustomerById(long customerId) {
        CustomerEntity customerEntity = customerRepository.findById(customerId).get();
        Customer customer = new Customer(customerEntity);
        return customer;
    }

    public void updateCustomer(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity(customer);
        customerRepository.save(customerEntity);
    }

    public void deleteCustomerById(long id) {
        customerRepository.deleteById(id);
    }
}
