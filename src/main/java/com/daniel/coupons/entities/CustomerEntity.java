package com.daniel.coupons.entities;

import com.daniel.coupons.dto.Customer;

import javax.persistence.*;

@Entity
@Table(name = "Customers")
public class CustomerEntity {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @MapsId
    private UserEntity userEntity;

    @Column(name = "address")
    private String address;

    @Column(name = "amount_of_children")
    private Integer amountOfChildren;

    public CustomerEntity() {
    }

    public CustomerEntity(Customer customer) {
        UserEntity customerUserEntity = new UserEntity(customer.getUser());
        this.userEntity = customerUserEntity;
        this.address = customer.getAddress();
        this.amountOfChildren = customer.getAmountOfChildren();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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
        return "CustomersEntity{" +
                "id=" + id +
                ", userEntity=" + userEntity +
                ", address='" + address + '\'' +
                ", amountOfChildren=" + amountOfChildren +
                '}';
    }
}
