package com.xa.backend.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.backend.dtos.responses.CategoryResponseDto;
import com.xa.backend.entities.Category;
import com.xa.backend.repositories.CategoryRepository;
import com.xa.backend.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

  @Autowired
  private CategoryRepository categoryRepository;

  ModelMapper modelMapper = new ModelMapper();

  @Override
  public List<CategoryResponseDto> getAllCategories() {
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    List<Category> categories = categoryRepository.findAll();
    List<CategoryResponseDto> categoryResponseDtos = categories.stream().map(category -> modelMapper.map(category, CategoryResponseDto.class)).collect(java.util.stream.Collectors.toList());
    return categoryResponseDtos;
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
