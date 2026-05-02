package com.experimental_software.spring_adventures.sales.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "specialoffer", schema = "sales")
public class Specialoffer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "specialofferid", nullable = false)
  private Integer id;

  @Size(max = 255)
  @NotNull
  @Column(name = "description", nullable = false)
  private String description;

  @NotNull
  @ColumnDefault("0.00")
  @Column(name = "discountpct", nullable = false)
  private BigDecimal discountpct;

  @Size(max = 50)
  @NotNull
  @Column(name = "type", nullable = false, length = 50)
  private String type;

  @Size(max = 50)
  @NotNull
  @Column(name = "category", nullable = false, length = 50)
  private String category;

  @NotNull
  @Column(name = "startdate", nullable = false)
  private Instant startdate;

  @NotNull
  @Column(name = "enddate", nullable = false)
  private Instant enddate;

  @NotNull
  @ColumnDefault("0")
  @Column(name = "minqty", nullable = false)
  private Integer minqty;

  @Column(name = "maxqty")
  private Integer maxqty;

  @NotNull
  @ColumnDefault("uuid_generate_v1()")
  @Column(name = "rowguid", nullable = false)
  private UUID rowguid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
