package com.daniel.coupons.entities;

import com.daniel.coupons.dto.Category;

import javax.persistence.*;

@Entity
@Table(name = "Categories")
public class CategoryEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public CategoryEntity() {
    }

    public CategoryEntity(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
