package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import com.sisconesti.api.models.CityModel;
import com.sisconesti.api.projections.CityJoinMinProjection;
import com.sisconesti.api.projections.StateJoinMinProjection;

public interface CityService {
	
	List<CityModel> findAll();
	List<CityJoinMinProjection> seacheByName(String name);
	Optional<CityModel> findById(Long id);
	CityModel save(CityModel city);
	void delete(CityModel city);
	boolean existsByName(String name);
	

}
