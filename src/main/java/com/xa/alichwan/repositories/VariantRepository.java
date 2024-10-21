package com.xa.alichwan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xa.alichwan.entities.Variant;

public interface VariantRepository extends JpaRepository<Variant, Long> {
  @Query(value = "SELECT * FROM variants", nativeQuery = true)
  List<Variant> getAllVariants();
  
}
