package com.sisconesti.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sisconesti.api.models.StateModel;

public interface StateRepository extends JpaRepository<StateModel, Long>{

	boolean existsByNameState(String nameState);
	
	@Query(value = "select s from StateModel s where s.name like %?1%" )
	public List<StateModel> seacheByName(String name);
}
