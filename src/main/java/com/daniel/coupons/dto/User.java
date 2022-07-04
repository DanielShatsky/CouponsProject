package com.daniel.coupons.dto;

import com.daniel.coupons.entities.UserEntity;
import com.daniel.coupons.enums.UserType;

public class User {

    private long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Integer companyId;
    private UserType userType;

    public User() {
    }

    // For DB extractions (there WILL be an id for each user)
    public User(int id, String username, String password, String firstName, String lastName, Integer companyId, UserType userType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyId = companyId;
        this.userType = userType;
    }

    // For insertions (no id)
    public User(String username, String password, String firstName, String lastName, Integer companyId, UserType userType) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyId = companyId;
        this.userType = userType;
    }

    public User(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.password = userEntity.getPassword();
        this.firstName = userEntity.getFirstName();
        this.lastName = userEntity.getLastName();
        this.companyId = userEntity.getCompanyId();
        this.userType = userEntity.getUserType();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyId=" + companyId +
                ", userType='" + userType + '\'' +
                '}';
    }
}
