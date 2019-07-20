package com.alea.springboot.app.pokeapi.model.entity.pokemon;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
@Entity
public class Pokemon implements Serializable {

	//
	private static final long serialVersionUID = 7657288532834704464L;
	@Id
	private Integer id;
	private String name;
	private Integer height;
	private Integer weight;
	private @Column(name = "base_experience") @SerializedName("base_experience") Integer baseExperience;
	private @Transient @SerializedName("game_indices") List<VersionGameIndex> gameIndices;

}
