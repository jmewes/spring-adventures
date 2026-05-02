package com.experimental_software.spring_adventures.humanresources.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class EmployeedepartmenthistoryId implements Serializable {

  private static final long serialVersionUID = -6960643594166411615L;

  @NotNull
  @Column(name = "businessentityid", nullable = false)
  private Integer businessentityid;

  @NotNull
  @Column(name = "startdate", nullable = false)
  private LocalDate startdate;

  @NotNull
  @Column(name = "departmentid", nullable = false)
  private Short departmentid;

  @NotNull
  @Column(name = "shiftid", nullable = false)
  private Short shiftid;
}
