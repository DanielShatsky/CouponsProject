package com.daniel.coupons.repositories;

import com.daniel.coupons.entities.CompanyEntity;
import com.daniel.coupons.entities.CouponEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICouponRepository extends CrudRepository<CouponEntity, Long> {

    List<CouponEntity> findByCompanyId(long id);
    List<CouponEntity> findByCompanyIdAndCategoryId(long companyId, long categoryId);
}
