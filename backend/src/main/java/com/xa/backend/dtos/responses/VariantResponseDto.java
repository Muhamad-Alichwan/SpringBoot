package com.xa.backend.dtos.responses;

import com.xa.backend.entities.Product;

import lombok.Data;

@Data
public class VariantResponseDto {
  private Long id;
  private Product product;
  private String name;
  private String slug;
  private String description;
  private Double price;
  private Double stock;
  private Boolean isDeleted;
}
