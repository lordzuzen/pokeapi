package com.alea.springboot.app.pokeapi.entity.resource;

import java.io.Serializable;

import lombok.Data;

@Data
public class NamedAPIResource implements Serializable {

	// The name of the referenced resource.
	private String name;
	
	// The URL of the referenced resource.
	private String url;
	
	private static final long serialVersionUID = 8375569723311021346L;
}
