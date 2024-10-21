package com.xa.alichwan.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.alichwan.entities.Category;
import com.xa.alichwan.repositories.CategoryRepository;
import com.xa.alichwan.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public List<Category> getAllCategories() {
    return categoryRepository.getAllCategories();
  }

  @Override
  public Category saveCategory(Category category) {
    return categoryRepository.save(category);
  }

  @Override
  public Category getCategoryById(Long id) {
    return categoryRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteCategoriesById(Long id) {
    Category category = categoryRepository.findById(id).orElse(null);
    categoryRepository.deleteById(category.getId());
  }
  
}
