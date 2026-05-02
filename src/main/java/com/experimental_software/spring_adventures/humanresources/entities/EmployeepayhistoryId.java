package com.experimental_software.spring_adventures.humanresources.entities;

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
public class EmployeepayhistoryId implements Serializable {

  private static final long serialVersionUID = -2427650548918376798L;

  @NotNull
  @Column(name = "businessentityid", nullable = false)
  private Integer businessentityid;

  @NotNull
  @Column(name = "ratechangedate", nullable = false)
  private Instant ratechangedate;
}
