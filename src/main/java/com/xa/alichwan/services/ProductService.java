package com.xa.alichwan.services;

import java.util.List;

import com.xa.alichwan.entities.Product;

public interface ProductService {
  List<Product> getAllProducts();
  Product saveProduct(Product product);
  Product getProductById(Long id);
  void deleteProductById(Long id);
}
