package com.experimental_software.spring_adventures.purchasing.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "vendor", schema = "purchasing")
public class Vendor {

  @Id
  @Column(name = "businessentityid", nullable = false)
  private Integer id;

  @Column(name = "accountnumber", columnDefinition = "\"AccountNumber\" not null")
  private Object accountnumber;

  @Column(name = "name", columnDefinition = "\"Name\" not null")
  private Object name;

  @NotNull
  @Column(name = "creditrating", nullable = false)
  private Short creditrating;

  @ColumnDefault("true")
  @Column(name = "preferredvendorstatus", columnDefinition = "\"Flag\" not null")
  private Object preferredvendorstatus;

  @ColumnDefault("true")
  @Column(name = "activeflag", columnDefinition = "\"Flag\" not null")
  private Object activeflag;

  @Size(max = 1024)
  @Column(name = "purchasingwebserviceurl", length = 1024)
  private String purchasingwebserviceurl;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
