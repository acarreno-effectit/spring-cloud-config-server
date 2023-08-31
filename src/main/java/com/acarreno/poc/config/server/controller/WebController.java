package com.acarreno.poc.config.server.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.acarreno.poc.config.server.model.PropertyRequest;
import com.acarreno.poc.config.server.service.declaration.IConfigServerService;

@RestController
public class WebController {

  // ------------------
  // Atributos privados
  // ------------------

  @Autowired
  private IConfigServerService service;

  // ----------------
  // Metodos Publicos
  // ----------------

  @PostMapping(value = "/create-properties", consumes = {"application/json"},
      produces = {"application/json"})
  public List<String> createProperty(@RequestBody List<PropertyRequest> properties) {

    return service.createProperties(properties);
  }

}
