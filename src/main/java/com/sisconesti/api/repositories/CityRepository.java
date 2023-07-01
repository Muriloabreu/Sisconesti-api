package com.sisconesti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisconesti.api.models.CityModel;

public interface CityRepository extends JpaRepository<CityModel, Long>{
	
	boolean existsByName(String name);

}	