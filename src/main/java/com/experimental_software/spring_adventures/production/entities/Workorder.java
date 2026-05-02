package com.experimental_software.spring_adventures.production.entities;

import com.experimental_software.spring_adventures.production.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "workorder", schema = "production")
public class Workorder {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "workorderid", nullable = false)
  private Integer id;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "productid", nullable = false)
  private Product productid;

  @NotNull
  @Column(name = "orderqty", nullable = false)
  private Integer orderqty;

  @NotNull
  @Column(name = "scrappedqty", nullable = false)
  private Short scrappedqty;

  @NotNull
  @Column(name = "startdate", nullable = false)
  private Instant startdate;

  @Column(name = "enddate")
  private Instant enddate;

  @NotNull
  @Column(name = "duedate", nullable = false)
  private Instant duedate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "scrapreasonid")
  private Scrapreason scrapreasonid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
