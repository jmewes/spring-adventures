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
public class BusinessentitycontactId implements Serializable {

  private static final long serialVersionUID = -2321331369604768586L;

  @NotNull
  @Column(name = "businessentityid", nullable = false)
  private Integer businessentityid;

  @NotNull
  @Column(name = "personid", nullable = false)
  private Integer personid;

  @NotNull
  @Column(name = "contacttypeid", nullable = false)
  private Integer contacttypeid;
}
