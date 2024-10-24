package com.xa.alichwan.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// import org.springframework.stereotype.Repository;
import com.xa.alichwan.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
  // Native Query
  @Query(value = "SELECT * FROM products", nativeQuery = true)
  List<Product> getAllProducts();
  
  @Query("SELECT p FROM Product p WHERE p.categoryId = :categoryId")
  List<Product> getProductsByCategoryId(@Param("categoryId") Long categoryId);
  // Hibernate Query
  // @Query(value = "SELECT p FROM Product p where isDeleted = false")
  // List<Product> getAllProducts();

  @Query(value = "SELECT * FROM spring.products WHERE is_deleted = false and slug = ?1", nativeQuery = true)
  Product getProductBySlug(String slug);
  
} 
