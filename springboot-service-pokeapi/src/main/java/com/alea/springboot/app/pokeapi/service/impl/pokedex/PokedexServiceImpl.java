package com.alea.springboot.app.pokeapi.service.impl.pokedex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alea.springboot.app.pokeapi.entity.pokedex.Pokedex;
import com.alea.springboot.app.pokeapi.entity.pokedex.PokemonEntry;
import com.alea.springboot.app.pokeapi.repository.pokedex.PokedexRepository;
import com.alea.springboot.app.pokeapi.service.persistance.PokemonPersistanceService;
import com.alea.springboot.app.pokeapi.service.pokedex.IPokedexService;
import com.alea.springboot.app.pokeapi.service.pokemon.IPokemonService;

@Service
public class PokedexServiceImpl implements IPokedexService {

	@Autowired
	private PokedexRepository pokedexDAO;

	@Autowired
	private PokemonPersistanceService pokemonPersistanceService;

	@Autowired
	private IPokemonService pokemonService;

	@Override
	public Pokedex findPokedex(String value) {
		Pokedex pokedex = pokedexDAO.getPokedexByIdOrName(value);
		if (!cachedPokemons()) {
			for (PokemonEntry entry : pokedex.getPokemonEntries()) {
				pokemonService.save(pokemonService.findOne(entry.getPokemonSpecies().getName()));
			}
		}
		return pokedex;
	}

	private boolean cachedPokemons() {
		return pokemonPersistanceService.findAll().isEmpty() ? false : true;
	}
}
