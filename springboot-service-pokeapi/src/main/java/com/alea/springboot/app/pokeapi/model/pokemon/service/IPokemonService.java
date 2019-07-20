package com.alea.springboot.app.pokeapi.model.pokemon.service;

import com.alea.springboot.app.pokeapi.model.entity.pokemon.Pokemon;

public interface IPokemonService {

	public Pokemon findOne(String name);
	
}
