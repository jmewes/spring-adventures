package com.experimental_software.spring_adventures.production.entities;

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
@Table(name = "productreview", schema = "production")
public class Productreview {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "productreviewid", nullable = false)
  private Integer id;

  @NotNull
  @Column(name = "productid", nullable = false)
  private Integer productid;

  @Column(name = "reviewername", columnDefinition = "\"Name\" not null")
  private Object reviewername;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "reviewdate", nullable = false)
  private Instant reviewdate;

  @Size(max = 50)
  @NotNull
  @Column(name = "emailaddress", nullable = false, length = 50)
  private String emailaddress;

  @NotNull
  @Column(name = "rating", nullable = false)
  private Integer rating;

  @Size(max = 3850)
  @Column(name = "comments", length = 3850)
  private String comments;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
