package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import com.sisconesti.api.models.DepartmentModel;

public interface DepartmentService {
	
	List<DepartmentModel>findAll();
	Optional<DepartmentModel>findById(Long id);
	DepartmentModel save(DepartmentModel departmentModel);
	void delete(DepartmentModel departmentModel);
	boolean existsByName(String name);

}
