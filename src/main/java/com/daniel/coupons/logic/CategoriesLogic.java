package com.daniel.coupons.logic;

import com.daniel.coupons.dto.Category;
import com.daniel.coupons.dto.Company;
import com.daniel.coupons.entities.CategoryEntity;
import com.daniel.coupons.entities.CompanyEntity;
import com.daniel.coupons.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Category> getCategories(){
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        List<Category> categories = convertCategoryEntityListToCategoryList(categoryEntities);
        return categories;
    }

    private List<Category> convertCategoryEntityListToCategoryList(List<CategoryEntity> categoryEntities){
        List<Category> categories = new ArrayList<>();
        for(CategoryEntity categoryEntity : categoryEntities){
            Category category = new Category(categoryEntity);
            categories.add(category);
        }
        return categories;
    }

}
