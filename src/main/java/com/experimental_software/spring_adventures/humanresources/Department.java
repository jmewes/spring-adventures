package com.experimental_software.spring_adventures.humanresources;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "department", schema = "humanresources")
@Getter
@Setter
@NoArgsConstructor
public class Department {

  @Id
  @Column(name = "departmentid")
  private Integer departmentId;

  @Column(name = "name", length = 64)
  private String name;
}
