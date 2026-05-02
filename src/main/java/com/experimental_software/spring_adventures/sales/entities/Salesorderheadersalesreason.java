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
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "salesorderheadersalesreason", schema = "sales")
public class Salesorderheadersalesreason {

  @EmbeddedId private SalesorderheadersalesreasonId id;

  @MapsId("salesorderid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "salesorderid", nullable = false)
  private Salesorderheader salesorderid;

  @MapsId("salesreasonid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "salesreasonid", nullable = false)
  private Salesreason salesreasonid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
