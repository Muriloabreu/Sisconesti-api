package com.sisconesti.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sisconesti.api.models.CompanyModel;
import com.sisconesti.api.projections.CompanyJoinMinProjection;


public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {
	
	
	boolean existsByCorporateName(String name);
	boolean existsByFantasyName(String name);
	@Query(nativeQuery = true, value = "SELECT corporate_name, fantasy_name FROM tb_company WHERE fantasy_name LIKE %?1%")
	List<CompanyJoinMinProjection> seacheByNameCompany(String name);

}
