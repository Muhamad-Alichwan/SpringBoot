package com.xa.backend.dtos.responses;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CategoryResponseDto {
  private Long id;
  private String name;
  private String slug;
  private String description;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private Boolean isDeleted;
}
