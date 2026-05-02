package com.experimental_software.spring_adventures.sales.entities;

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
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "salesorderheader", schema = "sales")
public class Salesorderheader {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "salesorderid", nullable = false)
  private Integer id;

  @NotNull
  @ColumnDefault("0")
  @Column(name = "revisionnumber", nullable = false)
  private Short revisionnumber;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "orderdate", nullable = false)
  private Instant orderdate;

  @NotNull
  @Column(name = "duedate", nullable = false)
  private Instant duedate;

  @Column(name = "shipdate")
  private Instant shipdate;

  @NotNull
  @ColumnDefault("1")
  @Column(name = "status", nullable = false)
  private Short status;

  @ColumnDefault("true")
  @Column(name = "onlineorderflag", columnDefinition = "\"Name\" not null")
  private Object onlineorderflag;

  @Column(name = "purchaseordernumber", columnDefinition = "\"OrderNumber\"")
  private Object purchaseordernumber;

  @Column(name = "accountnumber", columnDefinition = "\"AccountNumber\"")
  private Object accountnumber;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "customerid", nullable = false)
  private Customer customerid;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "salespersonid")
  private Salesperson salespersonid;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "territoryid")
  private Salesterritory territoryid;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "creditcardid")
  private Creditcard creditcardid;

  @Size(max = 15)
  @Column(name = "creditcardapprovalcode", length = 15)
  private String creditcardapprovalcode;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "currencyrateid")
  private Currencyrate currencyrateid;

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

  @Column(name = "totaldue")
  private BigDecimal totaldue;

  @Size(max = 128)
  @Column(name = "comment", length = 128)
  private String comment;

  @NotNull
  @ColumnDefault("uuid_generate_v1()")
  @Column(name = "rowguid", nullable = false)
  private UUID rowguid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
