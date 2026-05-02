package com.experimental_software.spring_adventures.sales.entities;

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
public class CountryregioncurrencyId implements Serializable {

  private static final long serialVersionUID = -3695848505154041192L;

  @Size(max = 3)
  @NotNull
  @Column(name = "countryregioncode", nullable = false, length = 3)
  private String countryregioncode;

  @Size(max = 3)
  @NotNull
  @Column(name = "currencycode", nullable = false, length = 3)
  private String currencycode;
}
