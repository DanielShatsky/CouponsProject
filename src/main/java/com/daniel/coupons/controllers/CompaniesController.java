package com.daniel.coupons.controllers;

import com.daniel.coupons.dto.Company;
import com.daniel.coupons.logic.CompaniesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    @Autowired
    private CompaniesLogic companiesLogic;

    @PostMapping
    public long createCompany(@RequestBody Company company){
        System.out.println("1");
        return companiesLogic.createCompany(company);
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable("id") long id){
        return companiesLogic.getCompanyById(id);
    }

    @PutMapping
    public void updateCompany(@RequestBody Company company){
        companiesLogic.updateCompany(company);
    }

    @DeleteMapping("/{id}")
    public void deleteCompanyById(@PathVariable("id") long id){
        companiesLogic.deleteCompanyById(id);
    }
}
