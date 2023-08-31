package com.acarreno.poc.config.server.service.implementation;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.acarreno.poc.config.server.mapper.ConfigServerMapper;
import com.acarreno.poc.config.server.model.PropertyRequest;
import com.acarreno.poc.config.server.repository.PropertyRepository;
import com.acarreno.poc.config.server.service.declaration.IConfigServerService;

@Service
public class ConfigServerService implements IConfigServerService {

  // ------------------
  // Atributos Privados
  // ------------------

  @Autowired
  private PropertyRepository propertyRepository;

  @Autowired
  private ConfigServerMapper mapper;

  // ----------------
  // Metodos Publicos
  // ----------------

  @Override
  public List<String> createProperties(List<PropertyRequest> properties) {

    List<String> response = new ArrayList<>();

    for (PropertyRequest item : properties) {

      try {

        propertyRepository.save(mapper.toPropertyEntity(item));
        response.add(item.getKey() + " - OK");

      } catch (Exception e) {
        response.add(item.getKey() + " - ERROR");
      }

    }

    return response;
  }

}
