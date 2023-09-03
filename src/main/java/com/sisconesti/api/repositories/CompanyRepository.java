package com.sisconesti.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sisconesti.api.models.CompanyModel;


public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {
	
	
	boolean existsByCorporateName(String name);
	boolean existsByFantasyName(String name);
	@Query(value = "SELECT c.corporateName, c.fantasyName from CompanyModel c WHERE c.fantasyName LIKE %?1%")
	List<CompanyModel>seacheByName(String name);

}
