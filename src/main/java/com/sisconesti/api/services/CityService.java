package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import com.sisconesti.api.models.CityModel;

public interface CityService {
	
	List<CityModel> findAll();
	Optional<CityModel> findById(Long id);
	CityModel save(CityModel city);
	void delete(CityModel city);
	boolean existsByName(String name);
	

}
