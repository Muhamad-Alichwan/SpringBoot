package com.xa.alichwan.entities;

import java.util.List;

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

  @Column(name = "name", length = 50)
  private String name;

  @Column(name = "slug", length = 50, unique = true)
  private String slug;
  
  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "price")
  private Double price;

  @Column(name = "stock")
  private Double stock;

  @ManyToOne
  @JoinColumn(name = "product_id", insertable = false, updatable = false)
  private Product product;
  
  @Column(name = "product_id")
  private Long productId;

  @Column(name = "is_deleted")
  private Boolean isDeleted;

  @OneToMany(mappedBy = "variantId", cascade = CascadeType.ALL)
  private List<OrderDetail> orderDetails;
}
