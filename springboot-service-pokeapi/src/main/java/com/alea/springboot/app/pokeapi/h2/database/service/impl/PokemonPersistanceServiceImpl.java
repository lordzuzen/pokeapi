package com.alea.springboot.app.pokeapi.h2.database.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alea.springboot.app.pokeapi.h2.database.dao.PokemonPersistanceDAO;
import com.alea.springboot.app.pokeapi.h2.database.service.PokemonPersistanceService;
import com.alea.springboot.app.pokeapi.model.entity.pokemon.Pokemon;

@Service
public class PokemonPersistanceServiceImpl implements PokemonPersistanceService {

	@Autowired
	PokemonPersistanceDAO pokemonPersistanceDAO;
	
	@Override
	public void create(Pokemon pokemon) {
		pokemonPersistanceDAO.create(pokemon);
	}

	@Override
	public List<Pokemon> getHighestPokemons() {
		return pokemonPersistanceDAO.getHighestPokemons();
	}

}
