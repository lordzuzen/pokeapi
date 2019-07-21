package com.alea.springboot.app.pokeapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alea.springboot.app.pokeapi.model.entity.pokemon.Pokemon;
import com.alea.springboot.app.pokeapi.service.pokemon.IPokemonService;

@RestController
public class PokemonController {

	@Autowired
	IPokemonService pokemonService;
	
	@GetMapping("/highestPokemons")
	public List<Pokemon> findHighestPokemons() {
		return pokemonService.getHighestPokemons();
	}
	
	@GetMapping("/heaviestPokemons")
	public List<Pokemon> findHeaviestPokemons() {
		return pokemonService.getHeaviestPokemons();
	}
	
	@GetMapping("/moreBaseExperiencePokemons")
	public List<Pokemon> findMoreBaseExperiencePokemons() {
		return pokemonService.getMoreBaseExperiencePokemons();
	}
}
