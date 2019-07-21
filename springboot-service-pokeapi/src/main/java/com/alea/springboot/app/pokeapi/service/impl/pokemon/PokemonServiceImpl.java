package com.alea.springboot.app.pokeapi.service.impl.pokemon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alea.springboot.app.pokeapi.model.entity.pokemon.Pokemon;
import com.alea.springboot.app.pokeapi.repository.pokemon.PokemonRepository;
import com.alea.springboot.app.pokeapi.service.persistance.PokemonPersistanceService;
import com.alea.springboot.app.pokeapi.service.pokedex.IPokedexService;
import com.alea.springboot.app.pokeapi.service.pokemon.IPokemonService;
import com.alea.springboot.app.pokeapi.utils.Constants;

@Service
public class PokemonServiceImpl implements IPokemonService {

	@Autowired
	private PokemonRepository pokemonDAO;

	@Autowired
	private PokemonPersistanceService pokemonPersistanceService;

	@Autowired
	private IPokedexService pokedexService;

	@Override
	public Pokemon save(Pokemon pokemon) {
		return pokemonPersistanceService.create(pokemon);
	}

	@Override
	public Pokemon findOne(String name) {
		return pokemonDAO.getPokemonByName(name);
	}

	@Override
	public List<Pokemon> getHighestPokemons() {
		if (!cachedPokemons()) {
			pokedexService.findPokedex(Constants.KANTO_ID);
		}
		return pokemonPersistanceService.getHighestPokemons();
	}

	@Override
	public List<Pokemon> getHeaviestPokemons() {
		if (!cachedPokemons()) {
			pokedexService.findPokedex(Constants.KANTO_ID);
		}
		return pokemonPersistanceService.getHeaviestPokemons();
	}

	@Override
	public List<Pokemon> getMoreBaseExperiencePokemons() {
		if (!cachedPokemons()) {
			pokedexService.findPokedex(Constants.KANTO_ID);
		}
		return pokemonPersistanceService.getMoreBaseExperiencePokemons();
	}

	private boolean cachedPokemons() {
		return pokemonPersistanceService.findAll().isEmpty() ? false : true;
	}
}
