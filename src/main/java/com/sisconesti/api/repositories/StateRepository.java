package com.sisconesti.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sisconesti.api.models.StateModel;
import com.sisconesti.api.projections.StateJoinMinProjection;

public interface StateRepository extends JpaRepository<StateModel, Long>{

	
	
	@Query(value = "select s.name AS name, s.uf AS sigla from StateModel s where s.name like %?1%" )
	public List<StateJoinMinProjection> seacheByName(String name);
}
