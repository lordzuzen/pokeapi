package com.alea.springboot.app.pokeapi.model.pokedex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alea.springboot.app.pokeapi.model.entity.pokedex.Pokedex;
import com.alea.springboot.app.pokeapi.model.pokedex.dao.PokedexDAO;
import com.alea.springboot.app.pokeapi.model.pokedex.service.IPokedexService;

@Service
public class PokedexServiceImpl implements IPokedexService {

	@Autowired
	private PokedexDAO pokedexDAO;

	@Override
	public Pokedex findPokedex(String value) {
		return pokedexDAO.getPokedexByIdOrName(value);
	}
}
