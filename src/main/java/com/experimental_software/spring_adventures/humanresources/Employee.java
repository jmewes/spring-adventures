package com.experimental_software.spring_adventures.humanresources;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee", schema = "humanresources")
@Getter
@Setter
@NoArgsConstructor
public class Employee {

  @Id
  @Column(name = "businessentityid")
  private Integer businessentityId;

  @Column(name = "loginid")
  private String loginId;
}
