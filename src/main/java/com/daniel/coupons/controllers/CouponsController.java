package com.daniel.coupons.controllers;

import com.daniel.coupons.dto.Coupon;
import com.daniel.coupons.logic.CouponsLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
