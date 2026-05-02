package com.experimental_software.spring_adventures.sales.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "salesperson", schema = "sales")
public class Salesperson {

  @Id
  @Column(name = "businessentityid", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "territoryid")
  private Salesterritory territoryid;

  @Column(name = "salesquota")
  private BigDecimal salesquota;

  @NotNull
  @ColumnDefault("0.00")
  @Column(name = "bonus", nullable = false)
  private BigDecimal bonus;

  @NotNull
  @ColumnDefault("0.00")
  @Column(name = "commissionpct", nullable = false)
  private BigDecimal commissionpct;

  @NotNull
  @ColumnDefault("0.00")
  @Column(name = "salesytd", nullable = false)
  private BigDecimal salesytd;

  @NotNull
  @ColumnDefault("0.00")
  @Column(name = "saleslastyear", nullable = false)
  private BigDecimal saleslastyear;

  @NotNull
  @ColumnDefault("uuid_generate_v1()")
  @Column(name = "rowguid", nullable = false)
  private UUID rowguid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
