package com.acarreno.poc.config.server.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Property {

  private String name;

  private List<String> profiles;

  private String label;

  private String version;

  private String state;

  private List<PropertySource> propertySources;

}
