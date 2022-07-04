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
        long userId = usersLogic.createUser(user);
        user.setId(userId);

        CustomerEntity customersEntity = new CustomerEntity(customer);
        customerRepository.save(customersEntity);
        return customersEntity.getId();
    }
}
