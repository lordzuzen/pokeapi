package com.alea.springboot.app.pokeapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alea.springboot.app.pokeapi.model.entity.pokedex.Pokedex;
import com.alea.springboot.app.pokeapi.model.entity.pokedex.PokemonEntry;
import com.alea.springboot.app.pokeapi.model.entity.pokemon.Pokemon;
import com.alea.springboot.app.pokeapi.model.entity.pokemon.VersionGameIndex;
import com.alea.springboot.app.pokeapi.model.entity.resource.NamedAPIResource;
import com.alea.springboot.app.pokeapi.model.pokedex.service.IPokedexService;
import com.alea.springboot.app.pokeapi.model.entity.resource.APIResourceList;
import com.alea.springboot.app.pokeapi.model.pokemon.service.IPokemonService;
import com.alea.springboot.app.pokeapi.model.resource.service.IResourceService;

@RestController
public class PokemonController {

	@Autowired
	IPokemonService pokemonService;

	@Autowired
	IResourceService resourceService;

	@Autowired
	IPokedexService pokedexService;

	@GetMapping("/all/{limit}/{offset}")
	public APIResourceList all(@PathVariable Integer limit, @PathVariable Integer offset) {
		return resourceService.find(limit, offset);
	}

	@GetMapping("/id/{url}")
	public Pokemon findById(@PathVariable String url) {
		return pokemonService.findOne("https://pokeapi.co/api/v2/pokemon/1/");
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
			}
		}
		return pokemonList;
	}
}
