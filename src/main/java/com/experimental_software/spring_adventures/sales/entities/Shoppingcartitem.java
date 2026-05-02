package com.experimental_software.spring_adventures.sales.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "shoppingcartitem", schema = "sales")
public class Shoppingcartitem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "shoppingcartitemid", nullable = false)
  private Integer id;

  @Size(max = 50)
  @NotNull
  @Column(name = "shoppingcartid", nullable = false, length = 50)
  private String shoppingcartid;

  @NotNull
  @ColumnDefault("1")
  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "datecreated", nullable = false)
  private Instant datecreated;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
