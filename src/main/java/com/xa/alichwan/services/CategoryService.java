package com.xa.alichwan.services;

import java.util.List;

import com.xa.alichwan.dtos.responses.CategoryResponseDto;
import com.xa.alichwan.entities.Category;
public interface CategoryService {
  List<CategoryResponseDto> getAllCategories();
  Category saveCategory(Category category);
  Category getCategoryById(Long id);
  void deleteCategoriesById(Long id);
}
