package com.acarreno.poc.config.server.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.acarreno.poc.config.server.entity.PropertyEntity;
import com.acarreno.poc.config.server.entity.PropertyPK;
import com.acarreno.poc.config.server.model.PropertyRequest;
import com.acarreno.poc.config.server.util.EncriptorUtil;

@Component
public class ConfigServerMapper {

  // ------------------
  // Atributos Privados
  // ------------------

  @Autowired
  private EncriptorUtil encriptorUtil;

  // ----------------
  // Metodos Publicos
  // ----------------

  public PropertyEntity toPropertyEntity(PropertyRequest input) {

    PropertyPK pk = new PropertyPK();

    pk.setPropertyKey(input.getKey());
    pk.setApplication(input.getApplication());

    PropertyEntity output = new PropertyEntity();

    output.setPk(pk);
    output.setLabel(input.getLabel());
    output.setProfile(input.getProfile());
    output.setValue(encriptorUtil.encrypt(input.getValue()));

    return output;
  }

}
