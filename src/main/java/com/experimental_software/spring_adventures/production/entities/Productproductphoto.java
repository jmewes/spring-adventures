package com.experimental_software.spring_adventures.production.entities;

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
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "productproductphoto", schema = "production")
public class Productproductphoto {

  @EmbeddedId private ProductproductphotoId id;

  @MapsId("productid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "productid", nullable = false)
  private Product productid;

  @MapsId("productphotoid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "productphotoid", nullable = false)
  private Productphoto productphotoid;

  @ColumnDefault("false")
  @Column(name = "\"primary\"", columnDefinition = "\"Flag\" not null")
  private Object primary;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
