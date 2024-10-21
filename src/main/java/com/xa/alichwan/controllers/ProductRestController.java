package com.xa.alichwan.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xa.alichwan.dtos.requests.ProductRequestDto;
import com.xa.alichwan.dtos.responses.ProductResponseDto;
import com.xa.alichwan.entities.Product;
import com.xa.alichwan.services.ProductService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.MatchingStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.modelmapper.ModelMapper;
// import org.modelmapper.convention.MatchingStrategies;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/product")
public class ProductRestController {
  @Autowired
  ProductService productService;
  
  @GetMapping("")
  public ResponseEntity<?> getAllProduct() {
      LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
      // ModelMapper modelMapper = new ModelMapper();
      // modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
      try {
        List<Product> products = productService.getAllProducts();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for (Product product : products) {
          ProductResponseDto productResponseDto = new ProductResponseDto();
          productResponseDto.setName(product.getName());
          productResponseDto.setSlug(product.getSlug());
          productResponseDto.setDescription(product.getDescription());
          productResponseDto.setCategoryId(product.getCategory().getId());
          productResponseDto.setIsDeteled(product.getIsDeleted());
          productResponseDtos.add(productResponseDto);
        }
        // List<ProductResponseDto> productResponseDtos = products.stream().map(product -> modelMapper.map(product, ProductResponseDto.class)).collect(Collectors.toList());
        resultMap.put("status", 200);
        resultMap.put("message", "success");
        resultMap.put("data", productResponseDtos);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
        
      } catch (Exception e) {
        resultMap.put("status", 500);
        resultMap.put("message", "failed");
        resultMap.put("error", e);
        return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }

  @PostMapping("")
  public ResponseEntity<?> saveProduct(@RequestBody ProductRequestDto productRequestDto) {
      LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
      try {
        // Product product = modelMapper.map(productRequestDto, Product.class);
        Product product = new Product();
        product.setName(productRequestDto.getName());
        product.setSlug(productRequestDto.getSlug());
        product.setDescription(productRequestDto.getDescription());
        product.setCategoryId(productRequestDto.getCategoryId());
        product.setIsDeleted(productRequestDto.getIsDeleted());
        productService.saveProduct(product);
        resultMap.put("status", 200);
        resultMap.put("message", "success");
        resultMap.put("data", product);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
      } catch (Exception e) {
        resultMap.put("status", 500);
        resultMap.put("message", "failed");
        resultMap.put("error", e);
        return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<?> updateProductById(@PathVariable("id") Long id, @RequestBody ProductRequestDto productRequestDto) {
      LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
      try {
        Product product = productService.getProductById(id);
        product.setName(productRequestDto.getName());
        product.setSlug(productRequestDto.getSlug());
        product.setDescription(productRequestDto.getDescription());
        product.setCategoryId(productRequestDto.getCategoryId());
        product.setIsDeleted(productRequestDto.getIsDeleted());
        productService.saveProduct(product);
        resultMap.put("status", 200);
        resultMap.put("message", "success");
        resultMap.put("data", product);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
      } catch (Exception e) {
        resultMap.put("status", 500);
        resultMap.put("message", "failed");
        resultMap.put("error", e);
        return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteProductById(@PathVariable("id") Long id) {
      LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
      try {
        productService.deleteProductById(id);
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
