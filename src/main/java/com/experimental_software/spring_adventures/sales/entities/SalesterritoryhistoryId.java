package com.experimental_software.spring_adventures.sales.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class SalesterritoryhistoryId implements Serializable {

  private static final long serialVersionUID = 2957200257565463477L;

  @NotNull
  @Column(name = "businessentityid", nullable = false)
  private Integer businessentityid;

  @NotNull
  @Column(name = "startdate", nullable = false)
  private Instant startdate;

  @NotNull
  @Column(name = "territoryid", nullable = false)
  private Integer territoryid;
}
