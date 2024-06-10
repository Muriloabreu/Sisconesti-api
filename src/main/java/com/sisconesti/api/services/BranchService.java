package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import com.sisconesti.api.models.BranchModel;
import com.sisconesti.api.projections.BranchJoinAllProjection;
import com.sisconesti.api.projections.BranchJoinMinProjection;

public interface BranchService {
	
	List<BranchModel> findAll();
	List<BranchJoinMinProjection>seacheByName(String name);
	List<BranchJoinAllProjection>findAllById(Long id);
	Optional<BranchModel> findById(Long id);
	BranchModel save(BranchModel branch);
	void delete (BranchModel brance);
	boolean existsByName(String name);
	boolean existsByCnpj(String cnpj);

}
