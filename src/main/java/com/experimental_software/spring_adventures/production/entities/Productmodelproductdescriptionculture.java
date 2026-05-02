package com.experimental_software.spring_adventures.production.entities;

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
@Table(name = "productmodelproductdescriptionculture", schema = "production")
public class Productmodelproductdescriptionculture {

  @EmbeddedId private ProductmodelproductdescriptioncultureId id;

  @MapsId("productmodelid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "productmodelid", nullable = false)
  private Productmodel productmodelid;

  @MapsId("productdescriptionid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "productdescriptionid", nullable = false)
  private Productdescription productdescriptionid;

  @MapsId("cultureid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "cultureid", nullable = false)
  private Culture cultureid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
