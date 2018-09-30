package io.github.daisonp.estateagents.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Property implements Serializable {
	private static final long serialVersionUID = 352367182793337031L;
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@OneToOne
	private Address address;
	
	

}
