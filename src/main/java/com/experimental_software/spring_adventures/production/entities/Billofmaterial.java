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
@Table(name = "billofmaterials", schema = "production")
public class Billofmaterial {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "billofmaterialsid", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "productassemblyid")
  private Product productassemblyid;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "componentid", nullable = false)
  private Product componentid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "startdate", nullable = false)
  private Instant startdate;

  @Column(name = "enddate")
  private Instant enddate;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "unitmeasurecode", nullable = false)
  private Unitmeasure unitmeasurecode;

  @NotNull
  @Column(name = "bomlevel", nullable = false)
  private Short bomlevel;

  @NotNull
  @ColumnDefault("1.00")
  @Column(name = "perassemblyqty", nullable = false, precision = 8, scale = 2)
  private BigDecimal perassemblyqty;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
