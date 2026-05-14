package com.experimental_software.spring_adventures.purchasing.entities;

import com.experimental_software.spring_adventures.humanresources.entities.Employee;
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
@Table(name = "purchaseorderheader", schema = "purchasing")
public class Purchaseorderheader {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "purchaseorderid", nullable = false)
  private Integer id;

  @NotNull
  @ColumnDefault("0")
  @Column(name = "revisionnumber", nullable = false)
  private Short revisionnumber;

  @NotNull
  @ColumnDefault("1")
  @Column(name = "status", nullable = false)
  private Short status;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "employeeid", nullable = false)
  private Employee employeeid;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "vendorid", nullable = false)
  private Vendor vendorid;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "shipmethodid", nullable = false)
  private Shipmethod shipmethodid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "orderdate", nullable = false)
  private Instant orderdate;

  @Column(name = "shipdate")
  private Instant shipdate;

  @NotNull
  @ColumnDefault("0.00")
  @Column(name = "subtotal", nullable = false)
  private BigDecimal subtotal;

  @NotNull
  @ColumnDefault("0.00")
  @Column(name = "taxamt", nullable = false)
  private BigDecimal taxamt;

  @NotNull
  @ColumnDefault("0.00")
  @Column(name = "freight", nullable = false)
  private BigDecimal freight;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
