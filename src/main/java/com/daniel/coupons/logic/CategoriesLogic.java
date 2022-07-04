package com.daniel.coupons.logic;

import com.daniel.coupons.dto.Category;
import com.daniel.coupons.entities.CategoryEntity;
import com.daniel.coupons.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesLogic {

    @Autowired
    private ICategoryRepository categoryRepository;

    public long createCategory(Category category){
        CategoryEntity categoryEntity = new CategoryEntity(category);
        categoryRepository.save(categoryEntity);
        return categoryEntity.getId();
    }

    public Category getCategoryById(long id){
        CategoryEntity categoryEntity = categoryRepository.findById(id).get();
        Category category = new Category(categoryEntity);
        return category;
    }

    public void deleteCategoryById(long id){
        categoryRepository.deleteById(id);
    }

    public void updateCategory(Category category){
        CategoryEntity categoryEntity = new CategoryEntity(category);
        categoryRepository.save(categoryEntity);
    }



}
