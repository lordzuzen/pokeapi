package com.alea.springboot.app.pokeapi.model.resource.dao;

import org.springframework.stereotype.Service;

import com.alea.springboot.app.pokeapi.model.entity.pokemon.Pokemon;
import com.alea.springboot.app.pokeapi.model.entity.resource.NamedAPIResource;
import com.alea.springboot.app.pokeapi.model.entity.resource.APIResourceList;
import com.alea.springboot.app.pokeapi.utils.APIConnect;

@Service
public class ResourceDAO {

	public APIResourceList getAPIResourceList(int limit, int offset){
		StringBuilder json = new StringBuilder("https://pokeapi.co/api/v2/pokemon/?limit=").append(limit).append("&offset=").append(offset);
		String response = APIConnect.fromInternet(json.toString());
		return (new com.google.gson.Gson()).fromJson(response, APIResourceList.class);
	}
}



