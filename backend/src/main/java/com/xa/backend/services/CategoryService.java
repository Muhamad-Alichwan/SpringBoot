package com.xa.backend.services;

import java.util.List;

import com.xa.backend.dtos.responses.CategoryResponseDto;
import com.xa.backend.entities.Category;
public interface CategoryService {
  List<CategoryResponseDto> getAllCategories();
  Category saveCategory(Category category);
  Category getCategoryById(Long id);
  void deleteCategoriesById(Long id);
}
