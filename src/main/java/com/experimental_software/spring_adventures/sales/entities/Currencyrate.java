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
import java.math.BigDecimal;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "currencyrate", schema = "sales")
public class Currencyrate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "currencyrateid", nullable = false)
  private Integer id;

  @NotNull
  @Column(name = "currencyratedate", nullable = false)
  private Instant currencyratedate;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "fromcurrencycode", nullable = false)
  private Currency fromcurrencycode;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "tocurrencycode", nullable = false)
  private Currency tocurrencycode;

  @NotNull
  @Column(name = "averagerate", nullable = false)
  private BigDecimal averagerate;

  @NotNull
  @Column(name = "endofdayrate", nullable = false)
  private BigDecimal endofdayrate;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
