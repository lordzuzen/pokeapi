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

import com.alea.springboot.app.pokeapi.entity.pokemon.Pokemon;
import com.alea.springboot.app.pokeapi.repository.pokemon.PokemonRepository;
import com.alea.springboot.app.pokeapi.service.impl.pokemon.PokemonServiceImpl;
import com.alea.springboot.app.pokeapi.service.persistance.PokemonPersistanceService;
import com.alea.springboot.app.pokeapi.service.pokedex.IPokedexService;

@RunWith(MockitoJUnitRunner.class)
public class PokemonServiceTest {

	@Mock
	PokemonPersistanceService pokemonPersistanceService;

	@Mock
	PokemonRepository pokemonRepository;

	@Mock
	private IPokedexService pokedexService;

	@InjectMocks
	PokemonServiceImpl pokemonService;

	@Test
	public void whenSavePokemonItShouldReturnPokemon() {
		Pokemon pokemon = new Pokemon(1, "pikachu", 20, 40, 50, null);

		when(pokemonPersistanceService.create(pokemon)).thenReturn(pokemon);

		Pokemon createdPokemon = pokemonService.save(pokemon);

		assertThat(createdPokemon.getName()).isSameAs(pokemon.getName());
	}

	@Test
	public void whenFindOnePokemonItShouldReturnPokemon() {
		Pokemon pokemon = new Pokemon(1, "pikachu", 20, 40, 50, null);

		when(pokemonRepository.getPokemonByName(pokemon.getName())).thenReturn(pokemon);

		Pokemon findedPokemon = pokemonService.findOne(pokemon.getName());

		assertThat(findedPokemon.getName()).isSameAs(pokemon.getName());
	}

	@Test
	public void whenGetHeaviestPokemonsItShouldReturnPokemon() {
		Pokemon pokemon = new Pokemon(1, "pikachu", 20, 40, 50, null);
		List<Pokemon> pokemonList = new ArrayList<Pokemon>();
		pokemonList.add(pokemon);

		when(pokemonPersistanceService.getHeaviestPokemons()).thenReturn(pokemonList);

		List<Pokemon> heaviestPokemons = pokemonService.getHeaviestPokemons();

		assertThat(heaviestPokemons.get(0).getName()).isSameAs(pokemon.getName());
	}

	@Test
	public void whenGetHighestPokemonsItShouldReturnPokemon() {
		Pokemon pokemon = new Pokemon(1, "pikachu", 20, 40, 50, null);
		List<Pokemon> pokemonList = new ArrayList<Pokemon>();
		pokemonList.add(pokemon);

		when(pokemonPersistanceService.getHighestPokemons()).thenReturn(pokemonList);

		List<Pokemon> highestPokemons = pokemonService.getHighestPokemons();

		assertThat(highestPokemons.get(0).getName()).isSameAs(pokemon.getName());
	}

	@Test
	public void whenGetMoreBaseExperiencePokemonsItShouldReturnPokemon() {
		Pokemon pokemon = new Pokemon(1, "pikachu", 20, 40, 50, null);
		List<Pokemon> pokemonList = new ArrayList<Pokemon>();
		pokemonList.add(pokemon);

		when(pokemonPersistanceService.getMoreBaseExperiencePokemons()).thenReturn(pokemonList);

		List<Pokemon> moreBaseExperiencePokemons = pokemonService.getMoreBaseExperiencePokemons();

		assertThat(moreBaseExperiencePokemons.get(0).getName()).isSameAs(pokemon.getName());
	}
}
