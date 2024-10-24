package com.xa.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xa.backend.entities.OrderHeader;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Long> {
  @Query(value = "SELECT * FROM order_headers", nativeQuery = true)
  List<OrderHeader> getAllOrderHeaders();
}
