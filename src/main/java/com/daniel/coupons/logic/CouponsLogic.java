package com.daniel.coupons.logic;

import com.daniel.coupons.dto.Category;
import com.daniel.coupons.dto.Company;
import com.daniel.coupons.dto.Coupon;
import com.daniel.coupons.entities.CategoryEntity;
import com.daniel.coupons.entities.CompanyEntity;
import com.daniel.coupons.entities.CouponEntity;
import com.daniel.coupons.enums.ErrorType;
import com.daniel.coupons.exceptions.ApplicationException;
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

    public long createCoupon(Coupon coupon) throws ApplicationException {
        validateCoupon(coupon);

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

    public void updateCoupon(Coupon coupon) throws ApplicationException {
        validateCoupon(coupon);
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
        List<CouponEntity> couponEntities = couponRepository.findAll();
        List<Coupon> coupons = convertCouponEntityToCouponList(couponEntities);
        return coupons;
    }

    public List<Coupon> getCouponsByCompanyId(long companyId) {
        List<CouponEntity> couponEntities = couponRepository.findByCompanyId(companyId);
        List<Coupon> coupons = convertCouponEntityToCouponList(couponEntities);
        return coupons;
    }

    public List<Coupon> getCouponsByCompanyIdAndCategoryId(long companyId, long categoryId) {
        List<CouponEntity> couponEntities = couponRepository.findByCompanyIdAndCategoryId(companyId, categoryId);
        List<Coupon> coupons = convertCouponEntityToCouponList(couponEntities);
        return coupons;
    }

    public List<Coupon> getCouponsByMaxPrice(double maxPrice) {
        List<CouponEntity> couponEntities = couponRepository.findByMaxPrice(maxPrice);
        List<Coupon> coupons = convertCouponEntityToCouponList(couponEntities);
        return coupons;
    }

    public List<Coupon> getCouponsByCategoryId(long categoryId) {
        List<CouponEntity> couponEntities = couponRepository.findByCategoryId(categoryId);
        List<Coupon> coupons = convertCouponEntityToCouponList(couponEntities);
        return coupons;
    }

    private List<Coupon> convertCouponEntityToCouponList(List<CouponEntity> couponEntities){
        List<Coupon> coupons = new ArrayList<>();
        for(CouponEntity couponEntity : couponEntities){
            Coupon coupon = new Coupon(couponEntity);
            coupons.add(coupon);
        }
        return coupons;
    }

    private void validateCoupon(Coupon coupon) throws ApplicationException {
        if(coupon.getTitle() == null || coupon.getTitle().isEmpty()){
            throw new ApplicationException(ErrorType.INVALID_COUPON_TITLE);
        }
        if(coupon.getDescription() == null || coupon.getDescription().isEmpty()){
            throw new ApplicationException(ErrorType.INVALID_COUPON_DESCRIPTION);
        }
        if(coupon.getStartDate() == null){
            throw new ApplicationException(ErrorType.INVALID_COUPON_DATE);
        }
        if(coupon.getEndDate() == null) {
            throw new ApplicationException(ErrorType.INVALID_COUPON_DATE);
        }
        if(coupon.getAmount() < 0){
            throw new ApplicationException(ErrorType.INVALID_COUPON_AMOUNT);
        }
        if(coupon.getPrice() <= 0){
            throw new ApplicationException(ErrorType.INVALID_COUPON_PRICE);
        }
        if(!this.companiesLogic.isCompanyExistById(coupon.getCompanyId())){
            throw new ApplicationException(ErrorType.INVALID_COMPANY_ID);
        }
        if(!this.categoriesLogic.isCategoryExistById(coupon.getCategoryId())){
            throw new ApplicationException(ErrorType.INVALID_CATEGORY_ID);
        }
        if(coupon.getStartDate().after(coupon.getEndDate())){
            throw new ApplicationException(ErrorType.INVALID_COUPON_DATE);
        }
//        if(couponRepository.existByTitle(coupon.getTitle())){
//            throw new ApplicationException(ErrorType.COUPON_TITLE_ALREADY_EXIST);
//        }
    }
}
