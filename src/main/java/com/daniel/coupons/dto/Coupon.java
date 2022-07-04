package com.daniel.coupons.dto;

import com.daniel.coupons.entities.CouponEntity;

import java.util.Date;

public class Coupon {

    private long id;
    private long companyId;
    private long categoryId;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private int amount;
    private double price;
    private String image;

    public Coupon() {
    }

    public Coupon(CouponEntity couponEntity) {
        this.id = couponEntity.getId();
        this.companyId = couponEntity.getCompany().getId();
        this.categoryId = couponEntity.getCategory().getId();
        this.title = couponEntity.getTitle();
        this.description = couponEntity.getDescription();
        this.startDate = couponEntity.getStartDate();
        this.endDate = couponEntity.getEndDate();
        this.amount = couponEntity.getAmount();
        this.price = couponEntity.getPrice();
        this.image = couponEntity.getImage();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", amount=" + amount +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
