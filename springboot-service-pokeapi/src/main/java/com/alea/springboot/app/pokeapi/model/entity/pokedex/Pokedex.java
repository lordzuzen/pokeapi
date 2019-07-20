package com.alea.springboot.app.pokeapi.model.entity.pokedex;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Pokedex {

	@SerializedName("pokemon_entries")
	private List<PokemonEntry> pokemonEntries;
	
}
