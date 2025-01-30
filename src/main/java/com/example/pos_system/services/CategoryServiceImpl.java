package com.example.pos_system.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pos_system.entity.Category;
import com.example.pos_system.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        if (categoryRepository.findByName(category.getName()).isPresent()) {
            throw new IllegalArgumentException("Category name already exists");
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + id));

        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new IllegalArgumentException("Category not found with id: " + id);
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + id));
    }
    
}
