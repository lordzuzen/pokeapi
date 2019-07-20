package com.alea.springboot.app.pokeapi.model.entity.pokemon;

import java.io.Serializable;

import com.alea.springboot.app.pokeapi.model.entity.resource.NamedAPIResource;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class VersionGameIndex implements Serializable {
	
	// The internal id of an API resource within game data.
	@SerializedName("game_index")
	private Integer gameIndex;
	
	// The version relevent to this game index.
	private NamedAPIResource version;

	private static final long serialVersionUID = -8657309074925713922L;
}
