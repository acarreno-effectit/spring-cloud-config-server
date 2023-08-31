package com.acarreno.poc.config.server.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyRequest {

  private String key;

  private String application;

  private String value;

  private String label;

  private String profile;

}
