package com.xa.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xa.backend.entities.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    // Native Query
  @Query(value = "SELECT * FROM categories", nativeQuery = true)
  List<Category> getAllCategories();
}
