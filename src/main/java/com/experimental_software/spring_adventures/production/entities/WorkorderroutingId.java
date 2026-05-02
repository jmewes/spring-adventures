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
public class WorkorderroutingId implements Serializable {

  private static final long serialVersionUID = 7078465183184514559L;

  @NotNull
  @Column(name = "workorderid", nullable = false)
  private Integer workorderid;

  @NotNull
  @Column(name = "productid", nullable = false)
  private Integer productid;

  @NotNull
  @Column(name = "operationsequence", nullable = false)
  private Short operationsequence;
}
