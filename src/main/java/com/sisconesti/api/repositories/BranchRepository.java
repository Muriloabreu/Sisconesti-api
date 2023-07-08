package com.sisconesti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisconesti.api.models.BranchModel;


public interface BranchRepository extends JpaRepository<BranchModel, Long>{
	
	boolean existsByName(String name);
	boolean existsByCnpj(String cnpj);

}
