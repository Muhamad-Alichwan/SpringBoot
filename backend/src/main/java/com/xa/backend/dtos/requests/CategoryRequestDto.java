package com.xa.backend.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryRequestDto {

  private Long id;

  @NotBlank
  @NotNull
  @NotEmpty
  private String name;

  @NotBlank
  @NotNull
  @NotEmpty
  private String slug;
  
  @NotBlank
  @NotNull
  @NotEmpty
  private String description;

  @NotNull
  private Boolean isDeleted;
}
