package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import com.sisconesti.api.models.StateModel;
import com.sisconesti.api.projections.StateJoinMinProjection;

public interface StateService {
	
	List<StateModel> findAll();
	List<StateJoinMinProjection> seacheByName(String name);
	Optional<StateModel> findById(Long id);
	StateModel save(StateModel state);
	void delete(StateModel state);
//	boolean existsByNameState(String name);
	

}
