package com.experimental_software.spring_adventures.sales.entities;

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
public class SpecialofferproductId implements Serializable {

  private static final long serialVersionUID = -7668207758847316252L;

  @NotNull
  @Column(name = "specialofferid", nullable = false)
  private Integer specialofferid;

  @NotNull
  @Column(name = "productid", nullable = false)
  private Integer productid;
}
