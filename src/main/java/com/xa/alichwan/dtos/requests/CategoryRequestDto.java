package com.xa.alichwan.dtos.requests;

import lombok.Data;

@Data
public class CategoryRequestDto {
  private String name;
  private String slug;
  private String description;
  private Boolean isDeleted;
}
