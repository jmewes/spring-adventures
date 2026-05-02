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
public class ProductmodelillustrationId implements Serializable {

  private static final long serialVersionUID = -2415569470137816387L;

  @NotNull
  @Column(name = "productmodelid", nullable = false)
  private Integer productmodelid;

  @NotNull
  @Column(name = "illustrationid", nullable = false)
  private Integer illustrationid;
}
