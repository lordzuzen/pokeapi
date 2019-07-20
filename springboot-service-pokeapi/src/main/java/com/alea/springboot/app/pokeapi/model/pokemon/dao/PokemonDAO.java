package com.alea.springboot.app.pokeapi.model.pokemon.dao;

import org.springframework.stereotype.Service;

import com.alea.springboot.app.pokeapi.model.entity.pokemon.Pokemon;
import com.alea.springboot.app.pokeapi.utils.APIConnect;
import com.alea.springboot.app.pokeapi.utils.URLIndex;

@Service
public class PokemonDAO {
	
	public Pokemon getPokemonByName(String name){
		String response = APIConnect.fromInternet(URLIndex.POKEMON_URL.concat(name));
		return (new com.google.gson.Gson()).fromJson(response, Pokemon.class);
	}
}
