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
@Table(name = "address", schema = "person")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "addressid", nullable = false)
  private Integer id;

  @Size(max = 60)
  @NotNull
  @Column(name = "addressline1", nullable = false, length = 60)
  private String addressline1;

  @Size(max = 60)
  @Column(name = "addressline2", length = 60)
  private String addressline2;

  @Size(max = 30)
  @NotNull
  @Column(name = "city", nullable = false, length = 30)
  private String city;

  @Size(max = 15)
  @NotNull
  @Column(name = "postalcode", nullable = false, length = 15)
  private String postalcode;

  @Column(name = "spatiallocation")
  private byte[] spatiallocation;

  @NotNull
  @ColumnDefault("uuid_generate_v1()")
  @Column(name = "rowguid", nullable = false)
  private UUID rowguid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
