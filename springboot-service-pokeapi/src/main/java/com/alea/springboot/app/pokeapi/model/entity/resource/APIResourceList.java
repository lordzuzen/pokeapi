package com.alea.springboot.app.pokeapi.model.entity.resource;

import java.util.List;

import lombok.Data;

@Data
public class APIResourceList {

	// The total number of resources available from this API.
	private int count;
	// The URL for the next page in the list.
	private String next;
	// The URL for the previous page in the list.
	private String previous;
	// A list of un-named API resources.
	private List<NamedAPIResource> results;
	
}
