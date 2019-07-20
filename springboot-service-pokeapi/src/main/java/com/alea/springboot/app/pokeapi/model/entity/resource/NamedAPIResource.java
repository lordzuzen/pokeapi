package com.alea.springboot.app.pokeapi.model.entity.resource;

import lombok.Data;

@Data
public class NamedAPIResource {

	private String name;
	// The URL of the referenced resource.
	private String url;
	
}
