package com.alea.springboot.app.pokeapi.h2.database.service;

import java.util.List;

import javax.transaction.Transactional;

import com.alea.springboot.app.pokeapi.model.entity.pokemon.Pokemon;

public interface PokemonPersistanceService {

	public void create(Pokemon pokemon);
	
	public List<Pokemon> getHighestPokemons();
}
