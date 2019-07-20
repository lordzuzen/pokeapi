package com.alea.springboot.app.pokeapi.model.pokedex.service;

import com.alea.springboot.app.pokeapi.model.entity.pokedex.Pokedex;

public interface IPokedexService {

	public Pokedex findPokedex(String url);
	
}
