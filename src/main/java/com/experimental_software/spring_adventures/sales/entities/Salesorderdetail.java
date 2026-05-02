package com.experimental_software.spring_adventures.sales.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "salesorderdetail", schema = "sales")
public class Salesorderdetail {

  @EmbeddedId private SalesorderdetailId id;

  @MapsId("salesorderid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "salesorderid", nullable = false)
  private Salesorderheader salesorderid;

  @Size(max = 25)
  @Column(name = "carriertrackingnumber", length = 25)
  private String carriertrackingnumber;

  @NotNull
  @Column(name = "orderqty", nullable = false)
  private Short orderqty;

  @NotNull
  @JoinColumns({
    @JoinColumn(name = "specialofferid", referencedColumnName = "specialofferid", nullable = false),
    @JoinColumn(name = "productid", referencedColumnName = "productid", nullable = false)
  })
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Specialofferproduct specialofferproduct;

  @NotNull
  @Column(name = "unitprice", nullable = false)
  private BigDecimal unitprice;

  @NotNull
  @ColumnDefault("0.0")
  @Column(name = "unitpricediscount", nullable = false)
  private BigDecimal unitpricediscount;

  @NotNull
  @ColumnDefault("uuid_generate_v1()")
  @Column(name = "rowguid", nullable = false)
  private UUID rowguid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
