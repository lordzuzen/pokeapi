package com.alea.springboot.app.pokeapi.service.pokemon;

import java.util.List;

import com.alea.springboot.app.pokeapi.model.entity.pokemon.Pokemon;

public interface IPokemonService {

	public Pokemon save(Pokemon pokemon);
	
	public Pokemon findOne(String name);
	
	public List<Pokemon> getHighestPokemons();
	
	public List<Pokemon> getHeaviestPokemons();
	
	public List<Pokemon> getMoreBaseExperiencePokemons();
	
}
