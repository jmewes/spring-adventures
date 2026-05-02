package com.experimental_software.spring_adventures.person.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class EmailaddressId implements Serializable {

  private static final long serialVersionUID = -7648330522143645153L;

  @NotNull
  @Column(name = "businessentityid", nullable = false)
  private Integer businessentityid;

  @NotNull
  @ColumnDefault("nextval('person.emailaddress_emailaddressid_seq')")
  @Column(name = "emailaddressid", nullable = false)
  private Integer emailaddressid;
}
