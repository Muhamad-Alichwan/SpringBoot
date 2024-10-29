package com.xa.backend.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "products")
@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity{

  public Product(){}
  public Product(String name, String slug, String description, Long categoryId, Boolean isDeleted) {
    this.name = name;
    this.slug = slug;
    this.description = description;
    this.categoryId = categoryId;
    this.isDeleted = isDeleted;

  }
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotBlank
  @NotNull
  @NotEmpty
  @Column(name = "name", length = 50)
  private String name;

  @NotBlank
  @NotNull
  @NotEmpty
  @Column(name = "slug", length = 50, unique = true)
  private String slug;

  @NotBlank
  @NotNull
  @NotEmpty
  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @ManyToOne
  @JoinColumn(name = "category_id", insertable = false, updatable = false)
  @JsonBackReference
  private Category category;

  @Column(name = "category_id")
  private Long categoryId;

  @NotNull
  @Column(name = "is_deleted")
  private Boolean isDeleted;

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Variant> variants;
}
