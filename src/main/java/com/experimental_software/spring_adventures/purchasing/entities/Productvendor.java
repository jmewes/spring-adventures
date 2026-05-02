package com.experimental_software.spring_adventures.purchasing.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table(name = "productvendor", schema = "purchasing")
public class Productvendor {

  @EmbeddedId private ProductvendorId id;

  /* TODO Define module constraints
  @MapsId("productid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "productid", nullable = false)
  private Product productid;
   */

  @MapsId("businessentityid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "businessentityid", nullable = false)
  private Vendor businessentityid;

  @NotNull
  @Column(name = "averageleadtime", nullable = false)
  private Integer averageleadtime;

  @NotNull
  @Column(name = "standardprice", nullable = false)
  private BigDecimal standardprice;

  @Column(name = "lastreceiptcost")
  private BigDecimal lastreceiptcost;

  @Column(name = "lastreceiptdate")
  private Instant lastreceiptdate;

  @NotNull
  @Column(name = "minorderqty", nullable = false)
  private Integer minorderqty;

  @NotNull
  @Column(name = "maxorderqty", nullable = false)
  private Integer maxorderqty;

  @Column(name = "onorderqty")
  private Integer onorderqty;

  /* TODO Define module constraints
  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "unitmeasurecode", nullable = false)
  private Unitmeasure unitmeasurecode;
   */

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
