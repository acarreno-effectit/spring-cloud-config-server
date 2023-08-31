package com.acarreno.poc.config.server.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class PropertyPK implements Serializable {

  private static final long serialVersionUID = -839367661719249500L;

  @Column(name = "PROPERTY_KEY", nullable = false, length = 225)
  private String propertyKey;

  @Column(name = "APPLICATION", nullable = false, length = 225)
  private String application;


}
