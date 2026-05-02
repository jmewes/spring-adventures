package com.experimental_software.spring_adventures.production.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "illustration", schema = "production")
public class Illustration {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "illustrationid", nullable = false)
  private Integer id;

  @JdbcTypeCode(SqlTypes.SQLXML)
  @Column(name = "diagram")
  private Map<String, Object> diagram;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
