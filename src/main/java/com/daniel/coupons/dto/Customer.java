package com.daniel.coupons.dto;

import com.daniel.coupons.entities.CustomerEntity;

public class Customer {

    private long id;
    private User user;
    private String address;
    private Integer amountOfChildren;

    public Customer() {
    }

    public Customer(CustomerEntity customersEntity) {
        User customerEntityUser = new User(customersEntity.getUserEntity());
        this.user = customerEntityUser;
        this.address = customersEntity.getAddress();
        this.amountOfChildren = customersEntity.getAmountOfChildren();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAmountOfChildren() {
        return amountOfChildren;
    }

    public void setAmountOfChildren(Integer amountOfChildren) {
        this.amountOfChildren = amountOfChildren;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", user=" + user +
                ", address='" + address + '\'' +
                ", amountOfChildren=" + amountOfChildren +
                '}';
    }
}
