package com.xa.backend.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductResponseDto {
  private String name;
  private String slug;
  private String description;
  private Long categoryId;
  private LocalDateTime createdAt;
  private LocalDateTime updatableAt;
  private Boolean isDeleted;

  
}
