package com.acarreno.poc.config.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.acarreno.poc.config.server.entity.PropertyEntity;
import com.acarreno.poc.config.server.entity.PropertyPK;

@Repository
public interface PropertyRepository extends CrudRepository<PropertyEntity, PropertyPK> {

}
