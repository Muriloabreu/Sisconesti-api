package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import com.sisconesti.api.models.EmployeeModel;

public interface EmployeeService {
	
	
	List<EmployeeModel> findAll();
	Optional<EmployeeModel> findById(Long id);
	EmployeeModel save(EmployeeModel employee);
	void delete(EmployeeModel employee);
	boolean existsByMatricula(String matricula);
	boolean existsByCpf(String cpf);

}
