package com.xa.backend.dtos.responses;

import lombok.Data;

@Data
public class VariantResponseDto {
  private Long id;
  private Long categoryId;
  private Long productId;
  private String name;
  private String slug;
  private String description;
  private Double price;
  private Double stock;
  private Boolean isDeleted;
  private ProductResponseDto product;
}
