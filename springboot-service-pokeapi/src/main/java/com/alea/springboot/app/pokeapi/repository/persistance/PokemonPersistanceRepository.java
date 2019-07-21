package com.alea.springboot.app.pokeapi.repository.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alea.springboot.app.pokeapi.entity.pokemon.Pokemon;

public interface PokemonPersistanceRepository extends JpaRepository<Pokemon, Integer> {

	List<Pokemon> findTop5ByOrderByBaseExperienceDesc();
	
	List<Pokemon> findTop5ByOrderByHeightDesc();
	
	List<Pokemon> findTop5ByOrderByWeightDesc();

}
