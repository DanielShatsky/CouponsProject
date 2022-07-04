package com.daniel.coupons.repositories;

import com.daniel.coupons.entities.CompanyEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICompanyRepository extends CrudRepository<CompanyEntity, Long> {
}
