package com.daniel.coupons.repositories;

import com.daniel.coupons.dto.Coupon;
import com.daniel.coupons.entities.CompanyEntity;
import com.daniel.coupons.entities.CouponEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICouponRepository extends CrudRepository<CouponEntity, Long> {

    List<CouponEntity> findAll();
    List<CouponEntity> findByCompanyId(long id);
    List<CouponEntity> findByCompanyIdAndCategoryId(long companyId, long categoryId);

    @Query("SELECT c FROM CouponEntity c WHERE c.price <= :maxPrice")
    List<CouponEntity> findByMaxPrice(@Param("maxPrice") double maxPrice);

    List<CouponEntity> findByCategoryId(long categoryId);
}
