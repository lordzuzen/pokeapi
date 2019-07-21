package com.alea.springboot.app.pokeapi.entity.resource;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class APIResourceList implements Serializable {
	
	// The total number of resources available from this API.
	private int count;
	
	// The URL for the next page in the list.
	private String next;
	
	// The URL for the previous page in the list.
	private String previous;
	
	// A list of un-named API resources.
	private List<NamedAPIResource> results;
	
	private static final long serialVersionUID = -8081044701586057892L;
}
