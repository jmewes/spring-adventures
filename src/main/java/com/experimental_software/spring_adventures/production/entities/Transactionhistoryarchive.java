package com.experimental_software.spring_adventures.production.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "transactionhistoryarchive", schema = "production")
public class Transactionhistoryarchive {

  @Id
  @Column(name = "transactionid", nullable = false)
  private Integer id;

  @NotNull
  @Column(name = "productid", nullable = false)
  private Integer productid;

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
