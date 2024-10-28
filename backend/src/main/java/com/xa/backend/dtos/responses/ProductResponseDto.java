package com.xa.backend.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

import com.xa.backend.entities.Category;

@Data
public class ProductResponseDto {
  private Long id;
  private String name;
  private String slug;
  private String description;
  private Category category;
  private LocalDateTime createdAt;
  private LocalDateTime updatableAt;
  private Boolean isDeleted;

  
}
