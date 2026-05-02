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
import java.math.BigDecimal;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "employeepayhistory", schema = "humanresources")
public class Employeepayhistory {

  @EmbeddedId private EmployeepayhistoryId id;

  @MapsId("businessentityid")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "businessentityid", nullable = false)
  private Employee businessentityid;

  @NotNull
  @Column(name = "rate", nullable = false)
  private BigDecimal rate;

  @NotNull
  @Column(name = "payfrequency", nullable = false)
  private Short payfrequency;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
