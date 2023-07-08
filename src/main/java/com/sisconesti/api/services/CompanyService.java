package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import com.sisconesti.api.models.CompanyModel;

public interface CompanyService {

	List<CompanyModel> findAll();
	Optional<CompanyModel> findById(Long id);
	CompanyModel save(CompanyModel company);
	void delete (CompanyModel company);
	boolean existsByCorporateName(String name);
	boolean existsByFantasyName(String name);
	
}
