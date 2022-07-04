package com.daniel.coupons.entities;

import com.daniel.coupons.dto.Company;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Companies")
public class CompanyEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    private List<CouponEntity> coupons;

    public CompanyEntity() {
    }

    public CompanyEntity(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.phoneNumber = company.getPhoneNumber();
        this.address = company.getAddress();
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
        return "CompanyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
