package com.alea.springboot.app.pokeapi.model.entity.pokemon;

import com.alea.springboot.app.pokeapi.model.entity.resource.NamedAPIResource;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class VersionGameIndex {

	@SerializedName("game_index")
	private Integer gameIndex;
	private NamedAPIResource version;

}
