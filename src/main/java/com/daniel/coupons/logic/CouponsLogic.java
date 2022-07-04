package com.daniel.coupons.logic;

import com.daniel.coupons.dto.Category;
import com.daniel.coupons.dto.Company;
import com.daniel.coupons.dto.Coupon;
import com.daniel.coupons.entities.CategoryEntity;
import com.daniel.coupons.entities.CompanyEntity;
import com.daniel.coupons.entities.CouponEntity;
import com.daniel.coupons.repositories.ICouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponsLogic {

    @Autowired
    private ICouponRepository couponRepository;
    @Autowired
    private CompaniesLogic companiesLogic;
    @Autowired
    private CategoriesLogic categoriesLogic;

    public long createCoupon(Coupon coupon){
        Company company = companiesLogic.getCompanyById(coupon.getCompanyId());
        CompanyEntity companyEntity = new CompanyEntity(company);

        Category category = categoriesLogic.getCategoryById(coupon.getCategoryId());
        CategoryEntity categoryEntity = new CategoryEntity(category);

        CouponEntity couponEntity = new CouponEntity(coupon);
        couponEntity.setCompany(companyEntity);
        couponEntity.setCategory(categoryEntity);

        couponRepository.save(couponEntity);
        return couponEntity.getId();
    }

    public Coupon getCouponById(long id) {
        CouponEntity couponEntity = couponRepository.findById(id).get();
        Coupon coupon = new Coupon(couponEntity);
        return coupon;
    }

    public void updateCoupon(Coupon coupon) {
        Company company = companiesLogic.getCompanyById(coupon.getCompanyId());
        CompanyEntity companyEntity = new CompanyEntity(company);

        Category category = categoriesLogic.getCategoryById(coupon.getCategoryId());
        CategoryEntity categoryEntity = new CategoryEntity(category);

        CouponEntity couponEntity = new CouponEntity(coupon);
        couponEntity.setCompany(companyEntity);
        couponEntity.setCategory(categoryEntity);

        couponRepository.save(couponEntity);
    }

    public void deleteCouponById(long id) {
        couponRepository.deleteById(id);
    }
}
