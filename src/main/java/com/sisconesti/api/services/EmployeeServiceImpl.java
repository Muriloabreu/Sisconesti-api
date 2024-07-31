package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisconesti.api.models.EmployeeModel;
import com.sisconesti.api.repositories.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeModel> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<EmployeeModel> findById(Long id) {
		return employeeRepository.findById(id);
	}

	@Transactional
	@Override
	public EmployeeModel save(EmployeeModel employee) {
		return employeeRepository.save(employee);
	}

	@Transactional
	@Override
	public void delete(EmployeeModel employee) {
		employeeRepository.delete(employee);
	}

	@Override
	public boolean existsByMatricula(String matricula) {
		return employeeRepository.existsByMatricula(matricula);
	}

	@Override
	public boolean existsByCpf(String cpf) {
		return employeeRepository.existsByCpf(cpf);
	}

}
