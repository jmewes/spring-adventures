package com.experimental_software.spring_adventures.person.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "businessentity", schema = "person")
public class Businessentity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "businessentityid", nullable = false)
  private Integer id;

  @NotNull
  @ColumnDefault("uuid_generate_v1()")
  @Column(name = "rowguid", nullable = false)
  private UUID rowguid = UUID.randomUUID();

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate = Instant.now();
}
