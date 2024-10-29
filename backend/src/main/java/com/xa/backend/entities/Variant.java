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
import lombok.NoArgsConstructor;

@Entity
@Table(name = "variants")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Variant extends BaseEntity {
  
  public Variant(String name, String slug, String description, Long productId, Double price, Double stock,Boolean isDeleted) {
    this.name = name;
    this.slug = slug;
    this.description = description;
    this.productId = productId;
    this.price = price;
    this.stock = stock;
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

  @NotNull
  @Column(name = "price")
  private Double price;

  @NotNull
  @Column(name = "stock")
  private Double stock;

  @ManyToOne
  @JoinColumn(name = "product_id", insertable = false, updatable = false)
  @JsonBackReference
  private Product product;

  @Column(name = "product_id")
  private Long productId;

  @NotNull
  @Column(name = "is_deleted")
  private Boolean isDeleted;

  @OneToMany(mappedBy = "variantId", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<OrderDetail> orderDetails;
}
