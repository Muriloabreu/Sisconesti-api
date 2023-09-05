package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import com.sisconesti.api.models.CompanyModel;
import com.sisconesti.api.projections.CompanyJoinMinProjection;

public interface CompanyService {

	List<CompanyModel> findAll();
	List<CompanyJoinMinProjection>seacheByName(String name);
	Optional<CompanyModel> findById(Long id);
	CompanyModel save(CompanyModel company);
	void delete (CompanyModel company);
	boolean existsByCorporateName(String name);
	boolean existsByFantasyName(String name);
	
}
