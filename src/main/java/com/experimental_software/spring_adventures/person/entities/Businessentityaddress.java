package com.experimental_software.spring_adventures.person.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table(name = "businessentityaddress", schema = "person")
public class Businessentityaddress {

  @EmbeddedId private BusinessentityaddressId id;

  @MapsId("businessentityid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "businessentityid", nullable = false)
  private Businessentity businessentityid;

  @MapsId("addressid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "addressid", nullable = false)
  private Address addressid;

  @MapsId("addresstypeid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "addresstypeid", nullable = false)
  private Addresstype addresstypeid;

  @NotNull
  @ColumnDefault("uuid_generate_v1()")
  @Column(name = "rowguid", nullable = false)
  private UUID rowguid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
