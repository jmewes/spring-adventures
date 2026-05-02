package com.experimental_software.spring_adventures.production.entities;

import com.experimental_software.spring_adventures.production.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "transactionhistory", schema = "production")
public class Transactionhistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "transactionid", nullable = false)
  private Integer id;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "productid", nullable = false)
  private Product productid;

  @NotNull
  @Column(name = "referenceorderid", nullable = false)
  private Integer referenceorderid;

  @NotNull
  @ColumnDefault("0")
  @Column(name = "referenceorderlineid", nullable = false)
  private Integer referenceorderlineid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "transactiondate", nullable = false)
  private Instant transactiondate;

  @NotNull
  @Column(name = "transactiontype", nullable = false, length = Integer.MAX_VALUE)
  private String transactiontype;

  @NotNull
  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  @NotNull
  @Column(name = "actualcost", nullable = false)
  private BigDecimal actualcost;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
