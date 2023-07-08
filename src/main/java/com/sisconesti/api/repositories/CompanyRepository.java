package com.sisconesti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisconesti.api.models.CompanyModel;


public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {
	
	
	boolean existsByCorporateName(String name);
	boolean existsByFantasyName(String name);

}
