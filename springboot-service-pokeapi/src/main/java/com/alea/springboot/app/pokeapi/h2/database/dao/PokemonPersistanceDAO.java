package com.alea.springboot.app.pokeapi.h2.database.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alea.springboot.app.pokeapi.model.entity.pokemon.Pokemon;

public interface PokemonPersistanceDAO extends JpaRepository<Pokemon, Integer> {

	List<Pokemon> findTop5ByOrderByBaseExperienceDesc();
	
	List<Pokemon> findTop5ByOrderByHeightDesc();
	
	List<Pokemon> findTop5ByOrderByWeightDesc();

}
