package com.sisconesti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisconesti.api.models.SupplierModel;

public interface SupplierRepository extends JpaRepository<SupplierModel, Long>{
	
	
	boolean existsByName(String name);
	
	

}
