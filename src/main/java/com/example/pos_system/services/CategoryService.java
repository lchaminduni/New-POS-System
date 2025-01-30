package com.example.pos_system.services;

import java.util.List;

import com.example.pos_system.entity.Category;

public interface CategoryService {
    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
}
