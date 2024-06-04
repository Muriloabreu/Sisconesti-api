package com.sisconesti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisconesti.api.models.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>{
	
	boolean existByCpf(String cpf);
	boolean existByMatricula(String matricula);

}
