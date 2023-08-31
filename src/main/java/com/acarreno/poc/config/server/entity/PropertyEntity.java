package com.acarreno.poc.config.server.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "properties", schema = "properties")
public class PropertyEntity {

  @EmbeddedId
  private PropertyPK pk;

  @Column(name = "value", nullable = false)
  private String value;

  @Column(name = "profile", nullable = false, length = 128)
  private String profile;

  @Column(name = "label", nullable = false, length = 128)
  private String label;

}
