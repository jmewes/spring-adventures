package com.experimental_software.spring_adventures.production.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "location", schema = "production")
public class Location {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "locationid", nullable = false)
  private Integer id;

  @Column(name = "name", columnDefinition = "\"Name\" not null")
  private Object name;

  @NotNull
  @ColumnDefault("0.00")
  @Column(name = "costrate", nullable = false)
  private BigDecimal costrate;

  @NotNull
  @ColumnDefault("0.00")
  @Column(name = "availability", nullable = false, precision = 8, scale = 2)
  private BigDecimal availability;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
