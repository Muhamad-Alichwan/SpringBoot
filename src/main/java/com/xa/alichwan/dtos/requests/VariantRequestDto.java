package com.xa.alichwan.dtos.requests;

import lombok.Data;

@Data
public class VariantRequestDto {
  private Long categoryId;
  private Long productId;
  private String name;
  private String slug;
  private String description;
  private Double price;
  private Double stock;
  private Boolean isDeleted;
}
