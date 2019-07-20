package com.alea.springboot.app.pokeapi.dao.pokedex;

import org.springframework.stereotype.Service;

import com.alea.springboot.app.pokeapi.model.entity.pokedex.Pokedex;
import com.alea.springboot.app.pokeapi.utils.APIConnect;
import com.alea.springboot.app.pokeapi.utils.URLIndex;

@Service
public class PokedexDAO {
	
	public Pokedex getPokedexByIdOrName(String value){
		String response = APIConnect.fromInternet(URLIndex.POKEDEX_URL.concat(value));
		return (new com.google.gson.Gson()).fromJson(response, Pokedex.class);
	}
}
