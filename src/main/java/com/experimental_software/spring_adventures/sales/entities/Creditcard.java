package com.experimental_software.spring_adventures.sales.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "creditcard", schema = "sales")
public class Creditcard {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "creditcardid", nullable = false)
  private Integer id;

  @Size(max = 50)
  @NotNull
  @Column(name = "cardtype", nullable = false, length = 50)
  private String cardtype;

  @Size(max = 25)
  @NotNull
  @Column(name = "cardnumber", nullable = false, length = 25)
  private String cardnumber;

  @NotNull
  @Column(name = "expmonth", nullable = false)
  private Short expmonth;

  @NotNull
  @Column(name = "expyear", nullable = false)
  private Short expyear;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
