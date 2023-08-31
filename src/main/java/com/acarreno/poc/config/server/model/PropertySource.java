package com.acarreno.poc.config.server.model;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertySource {

  private String name;

  private Map<String, String> source;

}
