package com.daniel.coupons.entities;

import com.daniel.coupons.dto.Coupon;
import com.daniel.coupons.dto.Purchase;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Purchases")
public class PurchaseEntity {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private CustomerEntity customerEntity;

    @OneToOne
    private CouponEntity couponEntity;

    @Column(name = "amount")
    private int amount;

    @Column(name = "timestamp")
    private Date timestamp;

    public PurchaseEntity() {
    }

    public PurchaseEntity(Purchase purchase) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public CouponEntity getCouponEntity() {
        return couponEntity;
    }

    public void setCouponEntity(CouponEntity couponEntity) {
        this.couponEntity = couponEntity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "PurchaseEntity{" +
                "id=" + id +
                ", customerEntity=" + customerEntity +
                ", couponEntity=" + couponEntity +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }
}
