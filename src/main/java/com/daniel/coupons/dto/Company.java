package com.daniel.coupons.dto;

import com.daniel.coupons.entities.CompanyEntity;

public class Company {

    private long id;
    private String name;
    private String phoneNumber;
    private String address;

    public Company(){

    }

    public Company(CompanyEntity companyEntity){
        this.id = companyEntity.getId();
        this.name = companyEntity.getName();
        this.phoneNumber = companyEntity.getPhoneNumber();
        this.address = companyEntity.getAddress();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
