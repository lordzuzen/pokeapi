package com.alea.springboot.app.pokeapi.model.entity.pokemon;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Pokemon implements Serializable {
	
	// 
	private static final long serialVersionUID = 7657288532834704464L;
	private Integer id;
	private String name;
	private Integer height;
	private Integer weight;
	private @SerializedName("base_experience") Integer baseExperience;
	private @SerializedName("game_indices") List<VersionGameIndex> gameIndices;
	
}
