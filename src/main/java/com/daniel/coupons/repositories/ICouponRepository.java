package com.daniel.coupons.repositories;

import com.daniel.coupons.entities.CouponEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICouponRepository extends CrudRepository<CouponEntity, Long> {
}
