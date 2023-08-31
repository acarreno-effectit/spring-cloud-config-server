package com.acarreno.poc.config.server.service.declaration;

import java.util.List;
import com.acarreno.poc.config.server.model.PropertyRequest;

public interface IConfigServerService {

  List<String> createProperties(List<PropertyRequest> properties);

}
