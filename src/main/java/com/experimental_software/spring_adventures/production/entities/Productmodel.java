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
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "productmodel", schema = "production")
public class Productmodel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "productmodelid", nullable = false)
  private Integer id;

  @Column(name = "name", columnDefinition = "\"Name\" not null")
  private Object name;

  @JdbcTypeCode(SqlTypes.SQLXML)
  @Column(name = "catalogdescription")
  private Map<String, Object> catalogdescription;

  @JdbcTypeCode(SqlTypes.SQLXML)
  @Column(name = "instructions")
  private Map<String, Object> instructions;

  @NotNull
  @ColumnDefault("uuid_generate_v1()")
  @Column(name = "rowguid", nullable = false)
  private UUID rowguid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
