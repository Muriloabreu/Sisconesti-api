package com.sisconesti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisconesti.api.models.StateModel;

public interface StateRepository extends JpaRepository<StateModel, Long>{

	boolean existsByName(String nameState);
}
