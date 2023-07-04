package com.sisconesti.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sisconesti.api.models.CityModel;
import com.sisconesti.api.projections.CityJoinMinProjection;
import com.sisconesti.api.projections.StateJoinMinProjection;

public interface CityRepository extends JpaRepository<CityModel, Long>{
	
	boolean existsByName(String name);
	
	@Query(value = "select c from CityModel c where c.name, c.state like %?1% ")
	public List<CityJoinMinProjection> seacheByName(String name);

}	