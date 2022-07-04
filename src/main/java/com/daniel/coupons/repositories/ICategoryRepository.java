package com.daniel.coupons.repositories;

import com.daniel.coupons.entities.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<CategoryEntity, Long> {
}
