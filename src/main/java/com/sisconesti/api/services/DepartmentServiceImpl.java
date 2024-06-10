package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisconesti.api.models.DepartmentModel;
import com.sisconesti.api.repositories.DepartmentRepository;

import jakarta.transaction.Transactional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;


	@Override
	public List<DepartmentModel> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	public Optional<DepartmentModel> findById(Long id) {
		return departmentRepository.findById(id);
	}

	@Transactional
	@Override
	public DepartmentModel save(DepartmentModel departmentModel) {
		return departmentRepository.save(departmentModel);
	}

	@Transactional
	@Override
	public void delete(DepartmentModel departmentModel) {
		departmentRepository.delete(departmentModel);
	}

	@Override
	public boolean existsByName(String name) {
		return departmentRepository.existsByName(name);
	}

}
