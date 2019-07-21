package com.alea.springboot.app.pokeapi.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.alea.springboot.app.pokeapi.model.entity.pokemon.Pokemon;
import com.alea.springboot.app.pokeapi.service.pokemon.IPokemonService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(PokemonController.class)
public class PokemonControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	IPokemonService pokemonService;

	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void itShouldReturnHeaviestPokemon() throws Exception {

		List<Pokemon> pokemonList = new ArrayList<Pokemon>();

		Pokemon pokemon = new Pokemon();
		pokemon.setName("snorlax");

		pokemonList.add(pokemon);

		when(pokemonService.getHeaviestPokemons()).thenReturn(pokemonList);

		System.out.println(mapper.writeValueAsString(pokemonList));

		mockMvc.perform(get("/heaviestPokemons")
				.content(mapper.writeValueAsString(pokemonList))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name")
				.value(pokemon.getName()));
	}
	
	@Test
	public void itShouldReturnHighestPokemon() throws Exception {

		List<Pokemon> pokemonList = new ArrayList<Pokemon>();

		Pokemon pokemon = new Pokemon();
		pokemon.setName("onix");

		pokemonList.add(pokemon);

		when(pokemonService.getHighestPokemons()).thenReturn(pokemonList);

		System.out.println(mapper.writeValueAsString(pokemonList));

		mockMvc.perform(get("/highestPokemons")
				.content(mapper.writeValueAsString(pokemonList))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name")
				.value(pokemon.getName()));
	}
	
	@Test
	public void itShouldReturnMoreBaseExperience() throws Exception {

		List<Pokemon> pokemonList = new ArrayList<Pokemon>();

		Pokemon pokemon = new Pokemon();
		pokemon.setName("chansey");

		pokemonList.add(pokemon);

		when(pokemonService.getMoreBaseExperiencePokemons()).thenReturn(pokemonList);

		System.out.println(mapper.writeValueAsString(pokemonList));

		mockMvc.perform(get("/moreBaseExperiencePokemons")
				.content(mapper.writeValueAsString(pokemonList))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name")
				.value(pokemon.getName()));
	}
}
