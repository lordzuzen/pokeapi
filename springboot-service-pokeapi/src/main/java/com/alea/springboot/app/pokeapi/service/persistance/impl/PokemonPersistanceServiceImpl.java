package com.alea.springboot.app.pokeapi.service.persistance.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alea.springboot.app.pokeapi.entity.pokemon.Pokemon;
import com.alea.springboot.app.pokeapi.repository.persistance.PokemonPersistanceRepository;
import com.alea.springboot.app.pokeapi.service.persistance.PokemonPersistanceService;

@Service
public class PokemonPersistanceServiceImpl implements PokemonPersistanceService {

	@Autowired
	PokemonPersistanceRepository pokemonPersistanceDAO;
	
	@Override
	public Pokemon create(Pokemon pokemon) {
		pokemonPersistanceDAO.save(pokemon);
		return pokemon;
	}

	@Override
	public List<Pokemon> getHighestPokemons() {
		return pokemonPersistanceDAO.findTop5ByOrderByHeightDesc();
	}

	@Override
	public List<Pokemon> getHeaviestPokemons() {
		return pokemonPersistanceDAO.findTop5ByOrderByWeightDesc();
	}

	@Override
	public List<Pokemon> getMoreBaseExperiencePokemons() {
		return pokemonPersistanceDAO.findTop5ByOrderByBaseExperienceDesc();
	}
	
	@Override
	public List<Pokemon> findAll() {
		return pokemonPersistanceDAO.findAll();
	}

}
