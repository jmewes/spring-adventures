package com.experimental_software.spring_adventures.production.entities;

import com.experimental_software.spring_adventures.humanresources.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "document", schema = "production")
public class Document {

  @Id
  @ColumnDefault("'/'")
  @Column(name = "documentnode", nullable = false, length = Integer.MAX_VALUE)
  private String documentnode;

  @Size(max = 50)
  @NotNull
  @Column(name = "title", nullable = false, length = 50)
  private String title;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "owner", nullable = false)
  private Employee owner;

  @ColumnDefault("false")
  @Column(name = "folderflag", columnDefinition = "\"Flag\" not null")
  private Object folderflag;

  @Size(max = 400)
  @NotNull
  @Column(name = "filename", nullable = false, length = 400)
  private String filename;

  @Size(max = 8)
  @Column(name = "fileextension", length = 8)
  private String fileextension;

  @Size(max = 5)
  @NotNull
  @Column(name = "revision", nullable = false, length = 5)
  private String revision;

  @NotNull
  @ColumnDefault("0")
  @Column(name = "changenumber", nullable = false)
  private Integer changenumber;

  @NotNull
  @Column(name = "status", nullable = false)
  private Short status;

  @Column(name = "documentsummary", length = Integer.MAX_VALUE)
  private String documentsummary;

  @Column(name = "document")
  private byte[] document;

  @NotNull
  @ColumnDefault("uuid_generate_v1()")
  @Column(name = "rowguid", nullable = false)
  private UUID rowguid;

  @NotNull
  @ColumnDefault("now()")
  @Column(name = "modifieddate", nullable = false)
  private Instant modifieddate;
}
