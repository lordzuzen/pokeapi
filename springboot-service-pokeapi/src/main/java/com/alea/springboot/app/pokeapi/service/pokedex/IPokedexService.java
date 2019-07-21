package com.alea.springboot.app.pokeapi.service.pokedex;

import com.alea.springboot.app.pokeapi.entity.pokedex.Pokedex;

public interface IPokedexService {

	public Pokedex findPokedex(String url);
	
}
