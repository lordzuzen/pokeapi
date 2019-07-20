package com.alea.springboot.app.pokeapi.service.impl.pokemon;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alea.springboot.app.pokeapi.dao.pokemon.PokemonDAO;
import com.alea.springboot.app.pokeapi.h2.database.service.PokemonPersistanceService;
import com.alea.springboot.app.pokeapi.model.entity.pokedex.Pokedex;
import com.alea.springboot.app.pokeapi.model.entity.pokedex.PokemonEntry;
import com.alea.springboot.app.pokeapi.model.entity.pokemon.Pokemon;
import com.alea.springboot.app.pokeapi.service.pokedex.IPokedexService;
import com.alea.springboot.app.pokeapi.service.pokemon.IPokemonService;

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
