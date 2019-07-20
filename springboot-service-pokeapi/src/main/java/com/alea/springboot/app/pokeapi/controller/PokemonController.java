package com.alea.springboot.app.pokeapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alea.springboot.app.pokeapi.h2.database.dao.PokemonPersistanceDAO;
import com.alea.springboot.app.pokeapi.h2.database.service.PokemonPersistanceService;
import com.alea.springboot.app.pokeapi.model.entity.pokedex.Pokedex;
import com.alea.springboot.app.pokeapi.model.entity.pokedex.PokemonEntry;
import com.alea.springboot.app.pokeapi.model.entity.pokemon.Pokemon;
import com.alea.springboot.app.pokeapi.model.pokedex.service.IPokedexService;
import com.alea.springboot.app.pokeapi.model.pokemon.service.IPokemonService;

@RestController
public class PokemonController {

	@Autowired
	IPokemonService pokemonService;

	@Autowired
	IPokedexService pokedexService;
	
	@Autowired
	PokemonPersistanceService pokemonPersistanceService;

	@GetMapping("/id/{url}")
	public Pokemon findById(@PathVariable String url) {
		return pokemonService.findOne("bulbasaur");
	}

	@GetMapping("/findRedPokemons")
	public Pokedex findRedPokemons() {
		return pokedexService.findPokedex("kanto");
	}

	@GetMapping("/findAllRed")
	public List<Pokemon> findAll() {
		List<Pokemon> pokemonList = new ArrayList<>();
		Pokedex pokedex = pokedexService.findPokedex("kanto");
		if (pokedex != null && (pokedex.getPokemonEntries() != null && !pokedex.getPokemonEntries().isEmpty())) {
			for (PokemonEntry entry : pokedex.getPokemonEntries()) {
				Pokemon pokemon = pokemonService.findOne(entry.getPokemonSpecies().getName());
				pokemonList.add(pokemon);
				pokemonPersistanceService.create(pokemon);
			}
		}
		return pokemonList;
	}
	
	@GetMapping("/highestPokemons")
	public List<Pokemon> findHighestPokemons() {
		return pokemonPersistanceService.getHighestPokemons();
	}
}
