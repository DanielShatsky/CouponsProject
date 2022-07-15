package com.daniel.coupons.logic;

import com.daniel.coupons.dto.Company;
import com.daniel.coupons.entities.CompanyEntity;
import com.daniel.coupons.enums.ErrorType;
import com.daniel.coupons.exceptions.ApplicationException;
import com.daniel.coupons.repositories.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompaniesLogic {

    @Autowired
    private ICompanyRepository companyRepository;

    public long createCompany(Company company) throws ApplicationException {
        validateCreateCompany(company);
        validateCompany(company);
        CompanyEntity companyEntity = new CompanyEntity(company);
        companyRepository.save(companyEntity);
        return companyEntity.getId();
    }

    public Company getCompanyById(long id) throws ApplicationException {
        if (!isCompanyExistById(id)) {
            throw new ApplicationException(ErrorType.COMPANY_DOESNT_EXIST);
        }
        CompanyEntity companyEntity = companyRepository.findById(id).get();
        Company company = new Company(companyEntity);
        return company;
    }

    public void updateCompany(Company company) throws ApplicationException {
        validateUpdateCompany(company);
        validateCompany(company);
        CompanyEntity companyEntity = new CompanyEntity(company);
        companyRepository.save(companyEntity);
    }

    public void deleteCompanyById(long id) throws ApplicationException {
        if (!isCompanyExistById(id)) {
            throw new ApplicationException(ErrorType.COMPANY_DOESNT_EXIST);
        }
        companyRepository.deleteById(id);
    }

    public List<Company> getCompanies(){
        List<CompanyEntity> companyEntities = companyRepository.findAll();
        List<Company> companies = convertCompanyEntityListToCompanyList(companyEntities);
        return companies;
    }

    private List<Company> convertCompanyEntityListToCompanyList(List<CompanyEntity> companyEntities){
        List<Company> companies = new ArrayList<>();
        for(CompanyEntity companyEntity : companyEntities){
            Company company = new Company(companyEntity);
            companies.add(company);
        }
        return companies;
    }

    public boolean isCompanyExistById(long id){
        return companyRepository.existsById(id);
    }

    private void validateCreateCompany(Company company) throws ApplicationException {
        if(companyRepository.existsByName(company.getName())){
            throw new ApplicationException(ErrorType.COMPANY_ALREADY_EXIST);
        }
    }

    private void validateUpdateCompany(Company company) throws ApplicationException {
        if(!isCompanyExistById(company.getId())){
            throw new ApplicationException(ErrorType.COMPANY_DOESNT_EXIST);
        }
        if(companyRepository.findById(company.getId()).get().getName() != company.getName()){
            throw new ApplicationException(ErrorType.COMPANY_NAME_CANT_BE_CHANGED);
        }
    }

    private void validateCompany(Company company) throws ApplicationException {
        if(company.getName() == null || company.getName().isEmpty()){
            throw new ApplicationException(ErrorType.INVALID_COMPANY_NAME);
        }
        if(company.getPhoneNumber() == null || company.getPhoneNumber().isEmpty()){
            throw new ApplicationException(ErrorType.INVALID_COMPANY_PHONE_NUMBER);
        }
    }
}
