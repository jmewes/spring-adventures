package com.experimental_software.spring_adventures.humanresources.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "shift", schema = "humanresources")
public class Shift {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "shiftid", nullable = false)
  private Integer id;

  @Column(name = "name", columnDefinition = "\"Name\" not null")
  private Object name;

  @NotNull
  @Column(name = "starttime", nullable = false)
  private LocalTime starttime;

  @NotNull
  @Column(name = "endtime", nullable = false)
  private LocalTime endtime;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
