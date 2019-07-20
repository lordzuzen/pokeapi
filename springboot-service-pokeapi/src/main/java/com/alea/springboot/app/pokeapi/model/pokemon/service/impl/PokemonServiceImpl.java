package com.alea.springboot.app.pokeapi.model.pokemon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alea.springboot.app.pokeapi.model.entity.pokemon.Pokemon;
import com.alea.springboot.app.pokeapi.model.pokemon.dao.PokemonDAO;
import com.alea.springboot.app.pokeapi.model.pokemon.service.IPokemonService;

@Service
public class PokemonServiceImpl implements IPokemonService{

	@Autowired
	private PokemonDAO pokemonDAO;
	
	@Override
	public Pokemon findOne(String name) {
		return this.pokemonDAO.getPokemonByName(name);
	}

}
