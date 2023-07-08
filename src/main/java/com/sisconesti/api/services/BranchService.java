package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import com.sisconesti.api.models.BranchModel;

public interface BranchService {
	
	List<BranchModel> findAll();
	Optional<BranchModel> findById(Long id);
	BranchModel save(BranchModel branch);
	void delete (BranchModel brance);
	boolean existsByName(String name);
	boolean existsByCnpj(String cnpj);

}
