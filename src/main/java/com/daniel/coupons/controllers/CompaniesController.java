package com.daniel.coupons.controllers;

import com.daniel.coupons.dto.Company;
import com.daniel.coupons.exceptions.ApplicationException;
import com.daniel.coupons.logic.CompaniesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    @Autowired
    private CompaniesLogic companiesLogic;

    @PostMapping
    public long createCompany(@RequestBody Company company) throws ApplicationException {
        return companiesLogic.createCompany(company);
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable("id") long id) throws ApplicationException {
        return companiesLogic.getCompanyById(id);
    }

    @PutMapping
    public void updateCompany(@RequestBody Company company) throws ApplicationException {
        companiesLogic.updateCompany(company);
    }

    @DeleteMapping("/{id}")
    public void deleteCompanyById(@PathVariable("id") long id) throws ApplicationException {
        companiesLogic.deleteCompanyById(id);
    }

    @GetMapping
    public List<Company> getCompanies(){
        return companiesLogic.getCompanies();
    }
}
