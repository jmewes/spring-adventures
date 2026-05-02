package com.experimental_software.spring_adventures.sales.entities;

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
@Table(name = "salesterritoryhistory", schema = "sales")
public class Salesterritoryhistory {

  @EmbeddedId private SalesterritoryhistoryId id;

  @MapsId("businessentityid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "businessentityid", nullable = false)
  private Salesperson businessentityid;

  @MapsId("territoryid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "territoryid", nullable = false)
  private Salesterritory territoryid;

  @Column(name = "enddate")
  private Instant enddate;

  @NotNull
  @ColumnDefault("uuid_generate_v1()")
  @Column(name = "rowguid", nullable = false)
  private UUID rowguid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
