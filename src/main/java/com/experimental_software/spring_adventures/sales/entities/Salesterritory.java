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
@Table(name = "salesterritory", schema = "sales")
public class Salesterritory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "territoryid", nullable = false)
  private Integer id;

  @Column(name = "name", columnDefinition = "\"Name\" not null")
  private Object name;

  @Size(max = 50)
  @NotNull
  @Column(name = "\"group\"", nullable = false, length = 50)
  private String group;

  @NotNull
  @ColumnDefault("0.00")
  @Column(name = "salesytd", nullable = false)
  private BigDecimal salesytd;

  @NotNull
  @ColumnDefault("0.00")
  @Column(name = "saleslastyear", nullable = false)
  private BigDecimal saleslastyear;

  @NotNull
  @ColumnDefault("0.00")
  @Column(name = "costytd", nullable = false)
  private BigDecimal costytd;

  @NotNull
  @ColumnDefault("0.00")
  @Column(name = "costlastyear", nullable = false)
  private BigDecimal costlastyear;

  @NotNull
  @ColumnDefault("uuid_generate_v1()")
  @Column(name = "rowguid", nullable = false)
  private UUID rowguid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
