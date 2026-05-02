package com.experimental_software.spring_adventures.person.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "stateprovince", schema = "person")
public class Stateprovince {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "stateprovinceid", nullable = false)
  private Integer id;

  @Size(max = 3)
  @NotNull
  @Column(name = "stateprovincecode", nullable = false, length = 3)
  private String stateprovincecode;

  /* TODO Define module constraints
  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "countryregioncode", nullable = false)
  private Countryregion countryregioncode;
   */

  @ColumnDefault("true")
  @Column(name = "isonlystateprovinceflag", columnDefinition = "\"Flag\" not null")
  private Object isonlystateprovinceflag;

  @Column(name = "name", columnDefinition = "\"Name\" not null")
  private Object name;

  @NotNull
  @ColumnDefault("uuid_generate_v1()")
  @Column(name = "rowguid", nullable = false)
  private UUID rowguid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
