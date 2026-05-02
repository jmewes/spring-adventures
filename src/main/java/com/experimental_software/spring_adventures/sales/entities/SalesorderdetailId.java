package com.experimental_software.spring_adventures.sales.entities;

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
public class SalesorderdetailId implements Serializable {

  private static final long serialVersionUID = -9170614785285111089L;

  @NotNull
  @Column(name = "salesorderid", nullable = false)
  private Integer salesorderid;

  @NotNull
  @ColumnDefault("nextval('sales.salesorderdetail_salesorderdetailid_seq')")
  @Column(name = "salesorderdetailid", nullable = false)
  private Integer salesorderdetailid;
}
