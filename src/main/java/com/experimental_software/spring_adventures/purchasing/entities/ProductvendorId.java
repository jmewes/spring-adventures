package com.experimental_software.spring_adventures.purchasing.entities;

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
public class ProductvendorId implements Serializable {

  private static final long serialVersionUID = -297571746466631345L;

  @NotNull
  @Column(name = "productid", nullable = false)
  private Integer productid;

  @NotNull
  @Column(name = "businessentityid", nullable = false)
  private Integer businessentityid;
}
