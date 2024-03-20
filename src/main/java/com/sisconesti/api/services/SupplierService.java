package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import com.sisconesti.api.models.SupplierModel;

public interface SupplierService {
	
	List<SupplierModel>findAll();
	Optional<SupplierModel> findById(Long id);
	SupplierModel save(SupplierModel supplier);
	void delete(SupplierModel supplier);
	boolean existsByName(String name);

}
