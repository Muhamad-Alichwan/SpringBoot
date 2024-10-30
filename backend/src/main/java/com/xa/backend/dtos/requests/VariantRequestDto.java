package com.xa.backend.dtos.requests;

import lombok.Data;

@Data
public class VariantRequestDto {
  private Long id;
  private Long productId;
  private String name;
  private String slug;
  private String description;
  private Double price;
  private Double stock;
  private Boolean isDeleted;
}
