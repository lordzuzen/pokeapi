package com.alea.springboot.app.pokeapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.alea.springboot.app.pokeapi.entity.pokemon.Pokemon;
import com.alea.springboot.app.pokeapi.service.pokemon.IPokemonService;

@RestController
public class PokemonController {

	@Autowired
	IPokemonService pokemonService;

	@GetMapping("/highestPokemons")
	public List<Pokemon> findHighestPokemons() {
		try {
			return pokemonService.getHighestPokemons();
		} catch (Exception exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request");
		}
	}

	@GetMapping("/heaviestPokemons")
	public List<Pokemon> findHeaviestPokemons() {
		try {
			return pokemonService.getHeaviestPokemons();
		} catch (Exception exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request");
		}
	}

	@GetMapping("/moreBaseExperiencePokemons")
	public List<Pokemon> findMoreBaseExperiencePokemons() {
		try {
			return pokemonService.getMoreBaseExperiencePokemons();
		} catch (Exception exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request");
		}
	}
}
