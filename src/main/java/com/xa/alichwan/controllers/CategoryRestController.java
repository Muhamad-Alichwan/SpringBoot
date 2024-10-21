package com.xa.alichwan.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xa.alichwan.dtos.requests.CategoryRequestDto;
import com.xa.alichwan.dtos.responses.CategoryResponseDto;
import com.xa.alichwan.entities.Category;
import com.xa.alichwan.repositories.CategoryRepository;
import com.xa.alichwan.services.CategoryService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {
    
    // @Autowired
    // CategoryRepository categoryRepository;

    // @GetMapping("")
    // public ResponseEntity<?> getMethodName() {
    //     LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
    //     List<Category> categories = categoryRepository.findAll();
    //     resultMap.put("status", 200);
    //     resultMap.put("message", "success");
    //     resultMap.put("data", categories);
    //     return new ResponseEntity<>(resultMap, HttpStatus.OK);
    // }
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> getAllCategories() {
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        try {
            List<Category> categories = categoryService.getAllCategories();
            List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();
            for(Category category : categories){
                CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
                categoryResponseDto.setName(category.getName());
                categoryResponseDto.setSlug(category.getSlug());
                categoryResponseDto.setDescription(category.getDescription());
                categoryResponseDto.setIsDeleted(category.getIsDeleted());
                categoryResponseDtos.add(categoryResponseDto);
            }
            resultMap.put("status", 200);
            resultMap.put("message", "success");
            resultMap.put("data", categoryResponseDtos);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
            } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", "failed");
            resultMap.put("error", e);
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        try {
            Category category = new Category();
            category.setName(categoryRequestDto.getName());
            category.setSlug(categoryRequestDto.getSlug());
            category.setDescription(categoryRequestDto.getDescription());
            categoryService.saveCategory(category);
            resultMap.put("status", 200);
            resultMap.put("message", "success");
            resultMap.put("data", category);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", "failed");
            resultMap.put("error", e);
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategoryById(@PathVariable("id") Long id, @RequestBody CategoryRequestDto categoryRequestDto) {
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<String, Object>();
        try {
            Category category = categoryService.getCategoryById(id);
            category.setName(categoryRequestDto.getName());
            category.setSlug(categoryRequestDto.getSlug());
            category.setDescription(categoryRequestDto.getDescription());
            category.setIsDeleted(categoryRequestDto.getIsDeleted());
            categoryService.saveCategory(category);
            resultMap.put("status", 200);
            resultMap.put("message", "success");
            resultMap.put("data", category);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);

        } catch (Exception e) {
        resultMap.put("status", 500);
        resultMap.put("message", "failed");
        resultMap.put("error", e);
        return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("id") Long id) {
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        try {
            categoryService.deleteCategoriesById(id);
            resultMap.put("status", 200);
            resultMap.put("message", "success");
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
        resultMap.put("status", 500);
        resultMap.put("message", "failed");
        resultMap.put("error", e);
        return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}