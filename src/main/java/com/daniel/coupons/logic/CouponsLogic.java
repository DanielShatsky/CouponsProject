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

import java.util.ArrayList;
import java.util.List;

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

    public List<Coupon> getCoupons() {
        Iterable<CouponEntity> couponEntities = couponRepository.findAll();
        List<Coupon> coupons = new ArrayList<>();
        for(CouponEntity couponEntity : couponEntities){
            Coupon coupon = new Coupon(couponEntity);
            coupons.add(coupon);
        }
        return coupons;
    }

    public List<Coupon> getCouponsByCompanyId(long companyId) {
        List<CouponEntity> couponEntities = couponRepository.findByCompanyId(companyId);
        List<Coupon> coupons = new ArrayList<>();
        for(CouponEntity couponEntity : couponEntities){
            Coupon coupon = new Coupon(couponEntity);
            coupons.add(coupon);
        }
        return coupons;
    }

    public List<Coupon> getCouponsByCompanyIdAndCategoryId(long companyId, long categoryId) {
        List<CouponEntity> couponEntities = couponRepository.findByCompanyIdAndCategoryId(companyId, categoryId);
        List<Coupon> coupons = new ArrayList<>();
        for(CouponEntity couponEntity : couponEntities){
            Coupon coupon = new Coupon(couponEntity);
            coupons.add(coupon);
        }
        return coupons;
    }
}
