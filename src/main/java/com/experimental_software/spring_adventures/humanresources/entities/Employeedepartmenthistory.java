package com.experimental_software.spring_adventures.humanresources.entities;

import com.experimental_software.spring_adventures.humanresources.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "employeedepartmenthistory", schema = "humanresources")
public class Employeedepartmenthistory {

  @EmbeddedId private EmployeedepartmenthistoryId id;

  @MapsId("businessentityid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "businessentityid", nullable = false)
  private Employee businessentityid;

  @MapsId("departmentid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "departmentid", nullable = false)
  private Department departmentid;

  @MapsId("shiftid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "shiftid", nullable = false)
  private Shift shiftid;

  @Column(name = "enddate")
  private LocalDate enddate;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
