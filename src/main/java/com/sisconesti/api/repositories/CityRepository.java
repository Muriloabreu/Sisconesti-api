package com.sisconesti.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sisconesti.api.models.CityModel;
import com.sisconesti.api.projections.CityJoinMinProjection;
import com.sisconesti.api.projections.StateJoinMinProjection;

public interface CityRepository extends JpaRepository<CityModel, Long>{
	
	boolean existsByName(String name);
	
	@Query(nativeQuery = true, value = "SELECT ct.id, ct.name AS nameCity, st.name AS nameState, st.uf AS uf "
			+ "FROM tb_citys ct "
			+ "INNER JOIN tb_states st ON st.id = ct.state_id "
			+ "WHERE UPPER(ct.name) LIKE '%' || UPPER(?1) || '%'")
	public List<CityJoinMinProjection> seacheByName(String name);

}	