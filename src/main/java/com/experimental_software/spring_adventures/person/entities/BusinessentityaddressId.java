package com.experimental_software.spring_adventures.person.entities;

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
public class BusinessentityaddressId implements Serializable {

  private static final long serialVersionUID = -1200405100854802116L;

  @NotNull
  @Column(name = "businessentityid", nullable = false)
  private Integer businessentityid;

  @NotNull
  @Column(name = "addressid", nullable = false)
  private Integer addressid;

  @NotNull
  @Column(name = "addresstypeid", nullable = false)
  private Integer addresstypeid;
}
