package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import com.sisconesti.api.models.StateModel;

public interface StateService {
	
	List<StateModel> findAll();
	Optional<StateModel> findById(Long id);
	StateModel save(StateModel state);
	void delete(StateModel state);
	boolean existsByNameState(String nameState);

}
