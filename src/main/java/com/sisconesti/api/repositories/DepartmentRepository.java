package com.sisconesti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisconesti.api.models.DepartmentModel;

public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long> {
	
	boolean existsByName(String name);

}
