package com.alea.springboot.app.pokeapi.entity.pokedex;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pokedex {

	@SerializedName("pokemon_entries")
	private List<PokemonEntry> pokemonEntries;
	
}
