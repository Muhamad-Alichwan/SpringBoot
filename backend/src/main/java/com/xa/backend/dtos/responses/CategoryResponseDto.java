package com.xa.backend.dtos.responses;

import lombok.Data;

@Data
public class CategoryResponseDto {
  private String name;
  private String slug;
  private String description;
  private Boolean isDeleted;
}
