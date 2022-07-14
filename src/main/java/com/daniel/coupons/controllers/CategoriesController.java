package com.daniel.coupons.controllers;

import com.daniel.coupons.dto.Category;
import com.daniel.coupons.exceptions.ApplicationException;
import com.daniel.coupons.logic.CategoriesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesLogic categoriesLogic;

    @PostMapping
    public long createCategory(@RequestBody Category category) throws ApplicationException {
        return categoriesLogic.createCategory(category);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") long id){
        return categoriesLogic.getCategoryById(id);
    }

    @PutMapping
    public void updateCategory(@RequestBody Category category) throws ApplicationException {
        categoriesLogic.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable("id") long id){
        categoriesLogic.deleteCategoryById(id);
    }

    @GetMapping
    public List<Category> getCategories(){
        return categoriesLogic.getCategories();
    }
}
