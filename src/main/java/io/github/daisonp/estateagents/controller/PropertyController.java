package io.github.daisonp.estateagents.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.daisonp.estateagents.entity.Property;
import io.github.daisonp.estateagents.repository.AddressRepository;
import io.github.daisonp.estateagents.repository.PropertyRepository;

@RestController
@RequestMapping("/property")
public class PropertyController {
	
	private PropertyRepository propertyRepository;
	private AddressRepository addressRepository;
	
	@Autowired
	public PropertyController(PropertyRepository propertyRepository, AddressRepository addressRepository) {
		this.propertyRepository = propertyRepository;
		this.addressRepository = addressRepository;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody Property property) {
		if (property.getAddress() != null && property.getAddress().getId() == null) {
			property.setAddress(addressRepository.save(property.getAddress()));
		}
		property = propertyRepository.save(property);
		return ResponseEntity
				.created(URI.create("http://localhost/property/" +property.getId()))
				.body("Created");
	}

}
