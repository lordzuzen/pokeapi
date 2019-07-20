package com.alea.springboot.app.pokeapi.model.resource.service;

import com.alea.springboot.app.pokeapi.model.entity.resource.APIResourceList;

public interface IResourceService {

	public APIResourceList find(Integer limit, Integer offset);

}
