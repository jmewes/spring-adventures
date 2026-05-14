package com.experimental_software.spring_adventures.person.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "person", schema = "person")
public class Person {

  @Id
  @Column(name = "businessentityid", nullable = false)
  private Integer id;

  @MapsId
  @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = jakarta.persistence.CascadeType.ALL)
  @JoinColumn(name = "businessentityid", nullable = false)
  private Businessentity businessentity;

  @Size(max = 2)
  @NotNull
  @Column(name = "persontype", nullable = false, length = 2)
  private String persontype;

  @ColumnDefault("false")
  @Column(name = "namestyle", columnDefinition = "\"NameStyle\" not null")
  private boolean namestyle;

  @Size(max = 8)
  @Column(name = "title", length = 8)
  private String title;

  @Column(name = "firstname", columnDefinition = "\"Name\" not null")
  private String firstname;

  @Column(name = "middlename", columnDefinition = "\"Name\" ")
  private String middlename;

  @Column(name = "lastname", columnDefinition = "\"Name\" not null")
  private String lastname;

  @Size(max = 10)
  @Column(name = "suffix", length = 10)
  private String suffix;

  @NotNull
  @ColumnDefault("0")
  @Column(name = "emailpromotion", nullable = false)
  private Integer emailpromotion;

  @JdbcTypeCode(SqlTypes.SQLXML)
  @Column(name = "additionalcontactinfo")
  private Map<String, String> additionalcontactinfo;

  @JdbcTypeCode(SqlTypes.SQLXML)
  @Column(name = "demographics")
  private Map<String, Integer> demographics;

  @Column(name = "rowguid")
  private UUID rowguid = UUID.randomUUID();

  @UpdateTimestamp
  @Column(name = "modifieddate")
  private Instant modifieddate = Instant.now();

  @PrePersist
  void generateRowguidIfMissing() {
    if (rowguid == null) {
      rowguid = UUID.randomUUID();
    }
  }
}
