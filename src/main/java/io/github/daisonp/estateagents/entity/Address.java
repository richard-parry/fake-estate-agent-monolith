package io.github.daisonp.estateagents.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Address implements Serializable {
	private static final long serialVersionUID = -4867792967668844398L;
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	private String houseNumber;
	private String street;
	private String district;
	private String city;
	private String postCode;
	
}
