package com.experimental_software.spring_adventures.sales.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "countryregion", schema = "person")
public class Countryregion {

  @Id
  @Size(max = 3)
  @Column(name = "countryregioncode", nullable = false, length = 3)
  private String countryregioncode;

  // TODO [Reverse Engineering] generate columns from DB
}
