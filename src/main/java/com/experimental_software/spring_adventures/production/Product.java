package com.experimental_software.spring_adventures.production;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product", schema = "production")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Product {

  @Id
  @Column(name = "productid")
  private Integer productId;

  @Column(name = "productnumber")
  private String productNumber;

  @Column(name = "name")
  private String name;
}
