package com.daniel.coupons.repositories;

import com.daniel.coupons.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<UserEntity, Long> {

}
