package com.daniel.coupons.repositories;

import com.daniel.coupons.entities.CompanyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICompanyRepository extends CrudRepository<CompanyEntity, Long> {
    List<CompanyEntity> findAll();
    boolean existsByName(String name);
}
