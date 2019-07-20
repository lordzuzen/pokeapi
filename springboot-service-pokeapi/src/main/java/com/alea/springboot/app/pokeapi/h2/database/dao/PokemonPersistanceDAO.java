package com.alea.springboot.app.pokeapi.h2.database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.alea.springboot.app.pokeapi.model.entity.pokemon.Pokemon;

@Repository
public class PokemonPersistanceDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void create(Pokemon pokemon) {
		entityManager.persist(pokemon);
		System.out.println("Persisted " + pokemon.getName());
	}

	@Transactional
	public List<Pokemon> getHighestPokemons() {
		TypedQuery<Pokemon> query = entityManager.createQuery("select p from Pokemon p order by base_experience desc", Pokemon.class);
		return (List<Pokemon>) query.getResultList();
	}
}
