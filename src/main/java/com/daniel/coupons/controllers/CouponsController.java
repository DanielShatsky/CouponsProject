package com.daniel.coupons.controllers;

import com.daniel.coupons.dto.Coupon;
import com.daniel.coupons.logic.CouponsLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponsController {

    @Autowired
    private CouponsLogic couponsLogic;

    @PostMapping
    public long createCoupon(@RequestBody Coupon coupon){
        System.out.println(coupon.toString());
        return couponsLogic.createCoupon(coupon);
    }

    @GetMapping("/{id}")
    public Coupon getCouponById(@PathVariable("id") long id){
        return couponsLogic.getCouponById(id);
    }

    @PutMapping
    public void updateCoupon(@RequestBody Coupon coupon){
        couponsLogic.updateCoupon(coupon);
    }

    @DeleteMapping("/{id}")
    public void deleteCouponById(@PathVariable("id") long id){
        couponsLogic.deleteCouponById(id);
    }

    @GetMapping
    public List<Coupon> getCoupons(){
        return couponsLogic.getCoupons();
    }

    @GetMapping("/byCompanyId")
    public List<Coupon> getCouponsByCompanyId(@RequestParam("companyId") long companyId){
        return couponsLogic.getCouponsByCompanyId(companyId);
    }

    @GetMapping("/byMaxPrice")
    public List<Coupon> getCouponsByCompanyIdAndMaxPrice(@RequestParam("maxPrice") double maxPrice){
        return couponsLogic.getCouponsByMaxPrice(maxPrice);
    }

    @GetMapping("/byCategoryId")
    public List<Coupon> getCouponsByCategoryId(@RequestParam("categoryId") long categoryId){
        return couponsLogic.getCouponsByCategoryId(categoryId);
    }

    @GetMapping("/byCompanyIdAndCategoryId")
    public List<Coupon> getCouponsByCompanyIdAndCategoryId(@RequestParam("companyId") long companyId,
                                                           @RequestParam("categoryId") long categoryId){
        return couponsLogic.getCouponsByCompanyIdAndCategoryId(companyId, categoryId);
    }
}
