package com.daniel.coupons.repositories;

import com.daniel.coupons.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<CustomerEntity, Long> {

}
