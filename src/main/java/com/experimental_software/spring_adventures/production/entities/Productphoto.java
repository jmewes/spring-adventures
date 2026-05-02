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
@Table(name = "productphoto", schema = "production")
public class Productphoto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "productphotoid", nullable = false)
  private Integer id;

  @Column(name = "thumbnailphoto")
  private byte[] thumbnailphoto;

  @Size(max = 50)
  @Column(name = "thumbnailphotofilename", length = 50)
  private String thumbnailphotofilename;

  @Column(name = "largephoto")
  private byte[] largephoto;

  @Size(max = 50)
  @Column(name = "largephotofilename", length = 50)
  private String largephotofilename;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
