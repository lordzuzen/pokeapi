package com.alea.springboot.app.pokeapi.model.resource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alea.springboot.app.pokeapi.model.entity.resource.APIResourceList;
import com.alea.springboot.app.pokeapi.model.resource.dao.ResourceDAO;
import com.alea.springboot.app.pokeapi.model.resource.service.IResourceService;

@Service
public class ResourceService implements IResourceService {

	@Autowired
	ResourceDAO resourceDAO;
	
	@Override
	public APIResourceList find(Integer limit, Integer offset) {
		return resourceDAO.getAPIResourceList(limit, offset);
	}
}
