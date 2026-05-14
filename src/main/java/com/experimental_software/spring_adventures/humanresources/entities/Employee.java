package com.experimental_software.spring_adventures.humanresources.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Entity
@Table(name = "employee", schema = "humanresources")
public class Employee {

  @Id
  @Column(name = "businessentityid", nullable = false)
  private Integer id;

  /* TODO(GH-26) Reference entities from different modules by identity only
  @MapsId
  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "businessentityid", nullable = false)
  private Persons person;
   */

  @Size(max = 15)
  @NotNull
  @Column(name = "nationalidnumber", nullable = false, length = 15)
  private String nationalidnumber;

  @Size(max = 256)
  @NotNull
  @Column(name = "loginid", nullable = false, length = 256)
  private String loginid;

  @Size(max = 50)
  @NotNull
  @Column(name = "jobtitle", nullable = false, length = 50)
  private String jobtitle;

  @NotNull
  @Column(name = "birthdate", nullable = false)
  private LocalDate birthdate;

  @NotNull
  @Column(name = "maritalstatus", nullable = false, length = Integer.MAX_VALUE)
  private String maritalstatus;

  @NotNull
  @Column(name = "gender", nullable = false, length = Integer.MAX_VALUE)
  private String gender;

  @NotNull
  @Column(name = "hiredate", nullable = false)
  private LocalDate hiredate;

  @ColumnDefault("true")
  @Column(name = "salariedflag")
  private Boolean salariedflag;

  @NotNull
  @ColumnDefault("0")
  @Column(name = "vacationhours", nullable = false)
  private Short vacationhours;

  @NotNull
  @ColumnDefault("0")
  @Column(name = "sickleavehours", nullable = false)
  private Short sickleavehours;

  @ColumnDefault("true")
  @Column(name = "currentflag")
  private Boolean currentflag;

  @Column(name = "rowguid")
  private UUID rowguid;

  @UpdateTimestamp
  @Column(name = "modifieddate")
  private Instant modifieddate;

  @ColumnDefault("'/'")
  @Column(name = "organizationnode", length = Integer.MAX_VALUE)
  private String organizationnode;

  @PrePersist
  void generateRowguidIfMissing() {
    if (rowguid == null) {
      rowguid = UUID.randomUUID();
    }
  }
}
