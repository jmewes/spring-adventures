package com.experimental_software.spring_adventures.production.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "workorderrouting", schema = "production")
public class Workorderrouting {

  @EmbeddedId private WorkorderroutingId id;

  @MapsId("workorderid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "workorderid", nullable = false)
  private Workorder workorderid;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "locationid", nullable = false)
  private Location locationid;

  @NotNull
  @Column(name = "scheduledstartdate", nullable = false)
  private Instant scheduledstartdate;

  @NotNull
  @Column(name = "scheduledenddate", nullable = false)
  private Instant scheduledenddate;

  @Column(name = "actualstartdate")
  private Instant actualstartdate;

  @Column(name = "actualenddate")
  private Instant actualenddate;

  @Column(name = "actualresourcehrs", precision = 9, scale = 4)
  private BigDecimal actualresourcehrs;

  @NotNull
  @Column(name = "plannedcost", nullable = false)
  private BigDecimal plannedcost;

  @Column(name = "actualcost")
  private BigDecimal actualcost;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
