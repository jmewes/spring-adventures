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
public class SalesorderheadersalesreasonId implements Serializable {

  private static final long serialVersionUID = -4921094490214766536L;

  @NotNull
  @Column(name = "salesorderid", nullable = false)
  private Integer salesorderid;

  @NotNull
  @Column(name = "salesreasonid", nullable = false)
  private Integer salesreasonid;
}
