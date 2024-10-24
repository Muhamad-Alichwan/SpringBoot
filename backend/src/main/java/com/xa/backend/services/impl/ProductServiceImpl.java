package com.xa.backend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.backend.entities.Product;
import com.xa.backend.repositories.ProductRepository;
import com.xa.backend.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<Product> getAllProducts() {
    return productRepository.getAllProducts();
  }

  @Override
  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Product getProductById(Long id) {
    return productRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteProductById(Long id) {
    Product product = productRepository.findById(id).orElse(null);
    productRepository.deleteById(product.getId());
  }

  @Override
  public List<Product> getProductsByCategoryId(Long categoryId) {
    return productRepository.getProductsByCategoryId(categoryId);
  }
}
