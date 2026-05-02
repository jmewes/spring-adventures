package com.experimental_software.spring_adventures.person.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "password", schema = "person")
public class Password {

  @Id
  @Column(name = "businessentityid", nullable = false)
  private Integer id;

  @Size(max = 128)
  @NotNull
  @Column(name = "passwordhash", nullable = false, length = 128)
  private String passwordhash;

  @Size(max = 10)
  @NotNull
  @Column(name = "passwordsalt", nullable = false, length = 10)
  private String passwordsalt;

  @NotNull
  @ColumnDefault("uuid_generate_v1()")
  @Column(name = "rowguid", nullable = false)
  private UUID rowguid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
