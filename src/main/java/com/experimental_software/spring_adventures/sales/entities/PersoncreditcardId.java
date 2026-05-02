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
public class PersoncreditcardId implements Serializable {

  private static final long serialVersionUID = 5912265263470736873L;

  @NotNull
  @Column(name = "businessentityid", nullable = false)
  private Integer businessentityid;

  @NotNull
  @Column(name = "creditcardid", nullable = false)
  private Integer creditcardid;
}
