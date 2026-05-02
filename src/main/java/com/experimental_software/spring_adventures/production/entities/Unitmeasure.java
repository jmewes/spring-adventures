package com.experimental_software.spring_adventures.production.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "unitmeasure", schema = "production")
public class Unitmeasure {

  @Id
  @Size(max = 3)
  @Column(name = "unitmeasurecode", nullable = false, length = 3)
  private String unitmeasurecode;

  @Column(name = "name", columnDefinition = "\"Name\" not null")
  private Object name;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
