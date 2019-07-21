package com.alea.springboot.app.pokeapi.service.persistance;

import java.util.List;

import com.alea.springboot.app.pokeapi.entity.pokemon.Pokemon;

public interface PokemonPersistanceService {

	public Pokemon create(Pokemon pokemon);
	
	public List<Pokemon> getHighestPokemons();
	
	public List<Pokemon> getHeaviestPokemons();
	
	public List<Pokemon> getMoreBaseExperiencePokemons();
	
	public List<Pokemon> findAll();
}
