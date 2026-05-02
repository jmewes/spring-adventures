package com.experimental_software.spring_adventures.production.entities;

import com.experimental_software.spring_adventures.production.Product;
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
@Table(name = "productcosthistory", schema = "production")
public class Productcosthistory {

  @EmbeddedId private ProductcosthistoryId id;

  @MapsId("productid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "productid", nullable = false)
  private Product productid;

  @Column(name = "enddate")
  private Instant enddate;

  @NotNull
  @Column(name = "standardcost", nullable = false)
  private BigDecimal standardcost;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
