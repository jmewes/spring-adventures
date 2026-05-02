package com.experimental_software.spring_adventures.production.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ProductproductphotoId implements Serializable {

  private static final long serialVersionUID = -2395307224561601017L;

  @NotNull
  @Column(name = "productid", nullable = false)
  private Integer productid;

  @NotNull
  @Column(name = "productphotoid", nullable = false)
  private Integer productphotoid;
}
