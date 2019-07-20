package com.alea.springboot.app.pokeapi.model.pokemon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alea.springboot.app.pokeapi.h2.database.service.PokemonPersistanceService;
import com.alea.springboot.app.pokeapi.model.entity.pokedex.Pokedex;
import com.alea.springboot.app.pokeapi.model.entity.pokedex.PokemonEntry;
import com.alea.springboot.app.pokeapi.model.entity.pokemon.Pokemon;
import com.alea.springboot.app.pokeapi.model.pokedex.service.IPokedexService;
import com.alea.springboot.app.pokeapi.model.pokemon.dao.PokemonDAO;
import com.alea.springboot.app.pokeapi.model.pokemon.service.IPokemonService;

@Service
public class PokemonServiceImpl implements IPokemonService {

	@Autowired
	private PokemonDAO pokemonDAO;

	@Autowired
	private PokemonPersistanceService pokemonPersistanceService;

	@Autowired
	private IPokedexService pokedexService;

	@Override
	public void save(Pokemon pokemon) {
		pokemonPersistanceService.create(pokemon);
	}
	
	@Override
	public Pokemon findOne(String name) {
		return pokemonDAO.getPokemonByName(name);
	}

	@Override
	public List<Pokemon> getHighestPokemons() {
		if (!cachedPokemons()) {
			pokedexService.findPokedex("kanto");
		}
		return pokemonPersistanceService.getHighestPokemons();
	}

	@Override
	public List<Pokemon> getHeaviestPokemons() {
		if (!cachedPokemons()) {
			pokedexService.findPokedex("kanto");
		}
		return pokemonPersistanceService.getHeaviestPokemons();
	}

	@Override
	public List<Pokemon> getMoreBaseExperiencePokemons() {
		if (!cachedPokemons()) {
			pokedexService.findPokedex("kanto");
		}
		return pokemonPersistanceService.getMoreBaseExperiencePokemons();
	}

	private boolean cachedPokemons() {
		return pokemonPersistanceService.findAll().isEmpty() ? false : true;
	}
}
