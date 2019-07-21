package com.alea.springboot.app.pokeapi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.alea.springboot.app.pokeapi.model.entity.pokedex.Pokedex;
import com.alea.springboot.app.pokeapi.model.entity.pokedex.PokemonEntry;
import com.alea.springboot.app.pokeapi.model.entity.pokemon.Pokemon;
import com.alea.springboot.app.pokeapi.model.entity.resource.NamedAPIResource;
import com.alea.springboot.app.pokeapi.repository.pokedex.PokedexRepository;
import com.alea.springboot.app.pokeapi.service.impl.pokedex.PokedexServiceImpl;
import com.alea.springboot.app.pokeapi.service.impl.pokemon.PokemonServiceImpl;
import com.alea.springboot.app.pokeapi.service.persistance.PokemonPersistanceService;
import com.alea.springboot.app.pokeapi.utils.Constants;

@RunWith(MockitoJUnitRunner.class)
public class PokedexServiceTest {

	@Mock
	PokemonPersistanceService pokemonPersistanceService;
	
	@Mock
	PokemonServiceImpl pokemonService;

	@Mock
	PokedexRepository pokedexRepository;

	@InjectMocks
	PokedexServiceImpl pokedexService;

	@Test
	public void whenFindPokedexItShouldReturnPokedex() {
		NamedAPIResource resource = new NamedAPIResource();
		resource.setName("mew");
		
		PokemonEntry pokemonEntry = new PokemonEntry();
		pokemonEntry.setPokemonSpecies(resource);
		
		List<PokemonEntry> pokemonEntries = new ArrayList<PokemonEntry>();
		pokemonEntries.add(pokemonEntry);
		
		Pokedex pokedex = new Pokedex();
		pokedex.setPokemonEntries(pokemonEntries);		

		when(pokedexRepository.getPokedexByIdOrName(Constants.KANTO_ID)).thenReturn(pokedex);
		when(pokemonPersistanceService.findAll()).thenReturn(new ArrayList<Pokemon>());

		Pokedex createdPokedex = pokedexService.findPokedex(Constants.KANTO_ID);

		assertThat(createdPokedex.getPokemonEntries().get(0).getPokemonSpecies().getName()).isSameAs(resource.getName());
	}
}