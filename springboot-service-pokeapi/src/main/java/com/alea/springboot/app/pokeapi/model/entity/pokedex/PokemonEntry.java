package com.alea.springboot.app.pokeapi.model.entity.pokedex;

import com.alea.springboot.app.pokeapi.model.entity.resource.NamedAPIResource;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class PokemonEntry {

	@SerializedName("pokemon_species")
	private NamedAPIResource pokemonSpecies;
}
