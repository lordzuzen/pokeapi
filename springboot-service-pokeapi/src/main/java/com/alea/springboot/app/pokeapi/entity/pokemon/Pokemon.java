package com.alea.springboot.app.pokeapi.entity.pokemon;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon implements Serializable {

	// The identifier for this resource.
	private @Id Integer id;
	
	// The name for this resource.
	private String name;
	
	// The height of this Pokémon in decimetres. 
	private Integer height;
	
	// The weight of this Pokémon in hectograms.
	private Integer weight;
	
	// The base experience gained for defeating this Pokémon.
	private @Column(name = "base_experience") @SerializedName("base_experience") Integer baseExperience;
	
	// A list of game indices relevent to Pokémon item by generation.
	private @Transient @SerializedName("game_indices") List<VersionGameIndex> gameIndices;

	private static final long serialVersionUID = 7657288532834704464L;
}
