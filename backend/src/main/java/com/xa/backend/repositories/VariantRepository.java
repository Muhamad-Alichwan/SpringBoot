package com.xa.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xa.backend.entities.Variant;

public interface VariantRepository extends JpaRepository<Variant, Long> {
  @Query(value = "SELECT * FROM variants", nativeQuery = true)
  List<Variant> getAllVariants();

  @Query("SELECT v FROM Variant v WHERE v.productId = :productId")
  List<Variant> getVariantsByProductId(@Param("productId") Long productId);
  
}
