package com.experimental_software.spring_adventures.sales.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "salesreason", schema = "sales")
public class Salesreason {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "salesreasonid", nullable = false)
  private Integer id;

  @Column(name = "name", columnDefinition = "\"Name\" not null")
  private Object name;

  @Column(name = "reasontype", columnDefinition = "\"Name\" not null")
  private Object reasontype;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
