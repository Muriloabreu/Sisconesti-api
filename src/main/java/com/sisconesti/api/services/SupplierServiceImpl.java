package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisconesti.api.models.SupplierModel;
import com.sisconesti.api.repositories.SupplierRepository;

import jakarta.transaction.Transactional;

@Service
public class SupplierServiceImpl implements SupplierService{
	
	@Autowired
	SupplierRepository supplierRepository;

	@Override
	public List<SupplierModel> findAll() {
		
		return supplierRepository.findAll();
	}

	@Override
	public Optional<SupplierModel> findById(Long id) {
		
		return supplierRepository.findById(id);
	}

	@Override
	@Transactional
	public SupplierModel save(SupplierModel supplier) {
		
		return supplierRepository.save(supplier);
	}

	@Override
	@Transactional
	public void delete(SupplierModel supplier) {
		supplierRepository.delete(supplier);
		
	}

	@Override
	public boolean existsByName(String name) {
		
		return supplierRepository.existsByName(name);
	}

}
