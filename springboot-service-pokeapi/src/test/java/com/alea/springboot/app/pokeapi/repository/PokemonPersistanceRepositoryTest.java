package com.alea.springboot.app.pokeapi.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.alea.springboot.app.pokeapi.entity.pokemon.Pokemon;
import com.alea.springboot.app.pokeapi.repository.persistance.PokemonPersistanceRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PokemonPersistanceRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	@Autowired
	PokemonPersistanceRepository pokemonPersistanceRepository;

	@Test
	public void itShouldSavePokemon() {
		Pokemon pokemon = new Pokemon(1, "Pikachu", 20, 30, 40, null);
		pokemon = entityManager.persistAndFlush(pokemon);
		
		assertThat(pokemonPersistanceRepository.findById(pokemon.getId()).get()).isEqualTo(pokemon);
	}
	
	@Test
	public void itShouldReturnHighestPokemons() {
		Pokemon pokemon = new Pokemon(1, "Pikachu", 10, 10, 40, null);
		pokemon = entityManager.persistAndFlush(pokemon);
		
		// Highest
		Pokemon pokemon2 = new Pokemon(2, "Snorlax", 50, 20, 40, null);
		pokemon2 = entityManager.persistAndFlush(pokemon2);
		
		Pokemon pokemon3 = new Pokemon(3, "Mew", 30, 50, 40, null);
		pokemon3 = entityManager.persistAndFlush(pokemon3);
		
		List<Pokemon> highestPokemons = pokemonPersistanceRepository.findTop5ByOrderByHeightDesc();

		assertThat(highestPokemons.get(0).getHeight()).isSameAs(pokemon2.getHeight());
	}
	
	@Test
	public void itShouldReturnHeviestPokemons() {
		Pokemon pokemon = new Pokemon(1, "Pikachu", 20, 10, 40, null);
		pokemon = entityManager.persistAndFlush(pokemon);
		
		Pokemon pokemon2 = new Pokemon(2, "Snorlax", 20, 20, 40, null);
		pokemon2 = entityManager.persistAndFlush(pokemon2);
		
		// Heaviest
		Pokemon pokemon3 = new Pokemon(3, "Mew", 20, 50, 40, null);
		pokemon3 = entityManager.persistAndFlush(pokemon3);
		
		List<Pokemon> heaviestPokemons = pokemonPersistanceRepository.findTop5ByOrderByWeightDesc();

		assertThat(heaviestPokemons.get(0).getWeight()).isSameAs(pokemon3.getWeight());
	}
	
	@Test
	public void itShouldReturnMoreBaseExperiencePokemons() {
		Pokemon pokemon = new Pokemon(1, "Pikachu", 20, 10, 200, null);
		pokemon = entityManager.persistAndFlush(pokemon);
		
		Pokemon pokemon2 = new Pokemon(2, "Snorlax", 20, 20, 450, null);
		pokemon2 = entityManager.persistAndFlush(pokemon2);
		
		// More Base Experience
		Pokemon pokemon3 = new Pokemon(3, "Mew", 20, 50, 600, null);
		pokemon3 = entityManager.persistAndFlush(pokemon3);
		
		List<Pokemon> moreBaseExperiencePokemons = pokemonPersistanceRepository.findTop5ByOrderByBaseExperienceDesc();

		assertThat(moreBaseExperiencePokemons.get(0).getBaseExperience()).isSameAs(pokemon3.getBaseExperience());
	}
}
