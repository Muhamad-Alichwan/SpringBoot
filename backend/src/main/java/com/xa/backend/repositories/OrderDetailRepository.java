package com.xa.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xa.backend.entities.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
  @Query(value = "SELECT * FROM order_details", nativeQuery = true)
  List<OrderDetail> getAllOrderDetails();
}
