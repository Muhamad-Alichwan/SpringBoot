package com.xa.backend.services;

import java.util.List;

import com.xa.backend.entities.Product;

public interface ProductService {
  List<Product> getAllProducts();
  Product saveProduct(Product product);
  Product getProductById(Long id);
  void deleteProductById(Long id);
  List<Product> getProductsByCategoryId(Long categoryId);
}
