package com.xa.alichwan.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_details")
@Data
@EqualsAndHashCode (callSuper = true)
@NoArgsConstructor
public class OrderDetail extends BaseEntity {
  
  public OrderDetail(Double quantity, Double price, Boolean isDeleted) {
    this.quantity = quantity;
    this.price = price;
    this.isDeleted = isDeleted;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "quantity")
  private Double quantity;

  @Column(name = "price")
  private Double price;

  @Column(name = "is_deleted")
  private Boolean isDeleted;

  @ManyToOne
  @JoinColumn(name = "header_id", insertable = false, updatable = false)
  private OrderHeader headerId;

  @ManyToOne
  @JoinColumn(name = "variant_id", insertable = false, updatable = false)
  private Variant variantId;
}
