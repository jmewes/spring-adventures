package com.experimental_software.spring_adventures.sales.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "countryregioncurrency", schema = "sales")
public class Countryregioncurrency {

  @EmbeddedId private CountryregioncurrencyId id;

  @MapsId("countryregioncode")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "countryregioncode", nullable = false)
  private Countryregion countryregioncode;

  @MapsId("currencycode")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "currencycode", nullable = false)
  private Currency currencycode;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
