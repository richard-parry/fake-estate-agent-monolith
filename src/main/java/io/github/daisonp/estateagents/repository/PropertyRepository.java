package io.github.daisonp.estateagents.repository;

import org.springframework.data.repository.CrudRepository;

import io.github.daisonp.estateagents.entity.Property;

public interface PropertyRepository extends CrudRepository<Property, Long>{

}
