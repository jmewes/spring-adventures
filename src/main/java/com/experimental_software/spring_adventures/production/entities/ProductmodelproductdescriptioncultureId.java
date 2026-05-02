package com.experimental_software.spring_adventures.production.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ProductmodelproductdescriptioncultureId implements Serializable {

  private static final long serialVersionUID = -4467969004654768533L;

  @NotNull
  @Column(name = "productmodelid", nullable = false)
  private Integer productmodelid;

  @NotNull
  @Column(name = "productdescriptionid", nullable = false)
  private Integer productdescriptionid;

  @Size(max = 6)
  @NotNull
  @Column(name = "cultureid", nullable = false, length = 6)
  private String cultureid;
}
