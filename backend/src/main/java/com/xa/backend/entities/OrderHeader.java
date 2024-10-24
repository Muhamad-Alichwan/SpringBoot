package com.xa.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_headers")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class OrderHeader extends BaseEntity {
  
  public OrderHeader(Double amount, boolean isDeleted) {
    this.amount = amount;
    this.isDeleted = isDeleted;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "reference", length = 15, insertable = false, updatable = false)
  private String reference;

  @Column(name = "amount")
  private Double amount;

  @Column(name = "is_deleted")
  private Boolean isDeleted;
}
