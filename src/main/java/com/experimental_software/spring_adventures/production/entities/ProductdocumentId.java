package com.experimental_software.spring_adventures.production.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ProductdocumentId implements Serializable {

  private static final long serialVersionUID = 3537417668551624360L;

  @NotNull
  @Column(name = "productid", nullable = false)
  private Integer productid;

  @NotNull
  @ColumnDefault("'/'")
  @Column(name = "documentnode", nullable = false, length = Integer.MAX_VALUE)
  private String documentnode;
}
