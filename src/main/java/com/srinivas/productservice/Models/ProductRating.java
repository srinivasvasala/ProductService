package com.srinivas.productservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_rating")
public class ProductRating {
  @Id
  @Column(name = "id", nullable = false)
  private Long id;
  private Double rate;
  private Integer count;


}