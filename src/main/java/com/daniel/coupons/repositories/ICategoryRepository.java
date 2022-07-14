package com.daniel.coupons.repositories;

import com.daniel.coupons.entities.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICategoryRepository extends CrudRepository<CategoryEntity, Long> {

    List<CategoryEntity> findAll();
}
