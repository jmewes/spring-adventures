package com.experimental_software.spring_adventures.production.entities;

import com.experimental_software.spring_adventures.production.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "productinventory", schema = "production")
@IdClass(ProductInventory.ProductInventoryId.class)
@Getter
@Setter
@NoArgsConstructor
@NamedEntityGraph(
    name = "ProductInventory.product",
    attributeNodes = @NamedAttributeNode("product"))
public class ProductInventory {

  @Id
  @Column(name = "locationid")
  private Integer locationId;

  @Id
  @ManyToOne
  @JoinColumn(name = "productid")
  private Product product;

  @Column(name = "quantity")
  private short quantity;

  @Builder
  @AllArgsConstructor
  @NoArgsConstructor // JPA
  public static class ProductInventoryId implements Serializable {
    private Integer locationId;
    private Product product;
  }
}
