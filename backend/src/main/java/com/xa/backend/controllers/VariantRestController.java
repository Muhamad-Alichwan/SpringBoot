package com.xa.backend.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xa.backend.dtos.requests.VariantRequestDto;
import com.xa.backend.dtos.responses.VariantResponseDto;
import com.xa.backend.entities.Product;
import com.xa.backend.entities.Variant;
import com.xa.backend.repositories.VariantRepository;
import com.xa.backend.services.VariantService;
import com.xa.backend.services.ProductService;
import com.xa.backend.services.CategoryService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@SuppressWarnings("unused")
@RestController
@CrossOrigin("*")
@RequestMapping("/api/variant")
public class VariantRestController {

  @Autowired
  private VariantService variantService;

  @Autowired
  private ProductService productService;

  @Autowired
  private CategoryService categoryService;
  

  @GetMapping("")
  public ResponseEntity<?> getAllVariant() {
      LinkedHashMap<String, Object> resultMap = new LinkedHashMap<String, Object>();
      try {
        List<Variant> variants = variantService.getAllVariants();
        List<VariantResponseDto> variantResponseDtos = new ArrayList<>();
        for(Variant variant : variants) {
          VariantResponseDto variantResponseDto = new VariantResponseDto();
          variantResponseDto.setId(variant.getId());
          variantResponseDto.setName(variant.getName());
          variantResponseDto.setSlug(variant.getSlug());
          variantResponseDto.setDescription(variant.getDescription());
          variantResponseDto.setPrice(variant.getPrice());
          variantResponseDto.setStock(variant.getStock());
          variantResponseDto.setIsDeleted(variant.getIsDeleted());
          variantResponseDto.setProduct(variant.getProduct());
          variantResponseDtos.add(variantResponseDto);
        }
        resultMap.put("status", 200);
        resultMap.put("message", "success");
        resultMap.put("data", variantResponseDtos);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);

      } catch (Exception e) {
        resultMap.put("status", 500);
        resultMap.put("message", "failed");
        resultMap.put("error", e);
        return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getVariantById(@PathVariable Long id) {
      LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
      try {
        Variant variants = variantService.getVariantById(id);
        List<VariantResponseDto> variantResponseDtos = new ArrayList<>();
        VariantResponseDto variantResponseDto = new VariantResponseDto();
        variantResponseDto.setId(variants.getId());
        variantResponseDto.setProduct(variants.getProduct());
        variantResponseDto.setName(variants.getName());
        variantResponseDto.setSlug(variants.getSlug());
        variantResponseDto.setDescription(variants.getDescription());
        variantResponseDto.setPrice(variants.getPrice());
        variantResponseDto.setStock(variants.getStock());
        variantResponseDto.setIsDeleted(variants.getIsDeleted());
        variantResponseDtos.add(variantResponseDto);
        
        resultMap.put("status", 200);
        resultMap.put("message", "success");
        resultMap.put("data", variantResponseDtos);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);

      } catch (Exception e) {
        resultMap.put("status", 500);
        resultMap.put("message", "failed");
        resultMap.put("error", e);
        return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
  

  @PostMapping("")
  public ResponseEntity<?> saveVariant(@RequestBody VariantRequestDto variantRequestDto) {
    LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
    try {
      Variant variant = new Variant();
      variant.setProductId(variantRequestDto.getProductId());
      variant.setName(variantRequestDto.getName());
      variant.setSlug(variantRequestDto.getSlug());
      variant.setDescription(variantRequestDto.getDescription());
      variant.setPrice(variantRequestDto.getPrice());
      variant.setStock(variantRequestDto.getStock());
      variant.setIsDeleted(variantRequestDto.getIsDeleted());
      variantService.saveVariant(variant);
      resultMap.put("status", 200);
      resultMap.put("message", "success");
      resultMap.put("data", variant);
      return new ResponseEntity<>(resultMap, HttpStatus.OK);
    } catch (Exception e) {
      resultMap.put("status", 500);
      resultMap.put("message", "failed");
      resultMap.put("error", e);
      return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateVariantById(@PathVariable("id") Long id, @RequestBody VariantRequestDto variantRequestDto) {
    LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
    try {
      Product product = new Product();
      Variant variant = variantService.getVariantById(id);
      variant.setProductId(variantRequestDto.getProductId());
      variant.setName(variantRequestDto.getName());
      variant.setSlug(variantRequestDto.getSlug());
      variant.setDescription(variantRequestDto.getDescription());
      variant.setPrice(variantRequestDto.getPrice());
      variant.setStock(variantRequestDto.getStock());
      variant.setIsDeleted(variantRequestDto.getIsDeleted());
      variantService.saveVariant(variant);
      resultMap.put("status", 200);
      resultMap.put("message", "success");
      resultMap.put("data", variant);
      return new ResponseEntity<>(resultMap, HttpStatus.OK);
    } catch (Exception e) {
      resultMap.put("status", 500);
      resultMap.put("message", "failed");
      resultMap.put("error", e);
      return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteVariantById(@PathVariable("id") Long id) {
    LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
    try {
      variantService.deleteVariantById(id);
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
