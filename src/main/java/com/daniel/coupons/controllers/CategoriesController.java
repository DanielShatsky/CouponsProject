package com.daniel.coupons.controllers;

import com.daniel.coupons.dto.Category;
import com.daniel.coupons.logic.CategoriesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesLogic categoriesLogic;

    @PostMapping
    public long createCategory(@RequestBody Category category){
        return categoriesLogic.createCategory(category);
    }

    @GetMapping("/{id}")
    private Category getCategoryById(@PathVariable("id") long id){
        return categoriesLogic.getCategoryById(id);
    }

    @PutMapping
    private void updateCategory(@RequestBody Category category){
        categoriesLogic.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    private void deleteCategoryById(@PathVariable("id") long id){
        categoriesLogic.deleteCategoryById(id);
    }
}
