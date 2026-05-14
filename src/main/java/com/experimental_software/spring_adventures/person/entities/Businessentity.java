package com.experimental_software.spring_adventures.person.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Entity
@Table(name = "businessentity", schema = "person")
public class Businessentity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "businessentityid", nullable = false)
  private Integer id;

  @Column(name = "rowguid")
  private UUID rowguid;

  @UpdateTimestamp
  @Column(name = "modifieddate")
  private Instant modifieddate;

  @PrePersist
  void generateRowguidIfMissing() {
    if (rowguid == null) {
      rowguid = UUID.randomUUID();
    }
  }
}
