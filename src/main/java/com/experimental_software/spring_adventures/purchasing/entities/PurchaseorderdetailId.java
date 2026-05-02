package com.experimental_software.spring_adventures.purchasing.entities;

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
public class PurchaseorderdetailId implements Serializable {

  private static final long serialVersionUID = -6279101949404691231L;

  @NotNull
  @Column(name = "purchaseorderid", nullable = false)
  private Integer purchaseorderid;

  @NotNull
  @ColumnDefault("nextval('purchasing.purchaseorderdetail_purchaseorderdetailid_seq')")
  @Column(name = "purchaseorderdetailid", nullable = false)
  private Integer purchaseorderdetailid;
}
