package com.xa.alichwan.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.xa.alichwan.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    // Native Query
  @Query(value = "SELECT * FROM categories", nativeQuery = true)
  List<Category> getAllCategories();
}
