package com.experimental_software.spring_adventures.purchasing.entities;

import com.experimental_software.spring_adventures.production.Product;
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
@Table(name = "purchaseorderdetail", schema = "purchasing")
public class Purchaseorderdetail {

  @EmbeddedId private PurchaseorderdetailId id;

  @MapsId("purchaseorderid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "purchaseorderid", nullable = false)
  private Purchaseorderheader purchaseorderid;

  @NotNull
  @Column(name = "duedate", nullable = false)
  private Instant duedate;

  @NotNull
  @Column(name = "orderqty", nullable = false)
  private Short orderqty;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "productid", nullable = false)
  private Product productid;

  @NotNull
  @Column(name = "unitprice", nullable = false)
  private BigDecimal unitprice;

  @NotNull
  @Column(name = "receivedqty", nullable = false, precision = 8, scale = 2)
  private BigDecimal receivedqty;

  @NotNull
  @Column(name = "rejectedqty", nullable = false, precision = 8, scale = 2)
  private BigDecimal rejectedqty;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
