package com.daniel.coupons.logic;

import com.daniel.coupons.dto.Company;
import com.daniel.coupons.entities.CompanyEntity;
import com.daniel.coupons.repositories.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompaniesLogic {

    @Autowired
    private ICompanyRepository companyRepository;

    public long createCompany(Company company){
        CompanyEntity companyEntity = new CompanyEntity(company);
        companyRepository.save(companyEntity);
        return companyEntity.getId();
    }

    public Company getCompanyById(long id){
        CompanyEntity companyEntity = companyRepository.findById(id).get();
        Company company = new Company(companyEntity);
        return company;
    }

    public void updateCompany(Company company){
        CompanyEntity companyEntity = new CompanyEntity(company);
        companyRepository.save(companyEntity);
    }

    public void deleteCompanyById(long id){
        companyRepository.deleteById(id);
    }
}
