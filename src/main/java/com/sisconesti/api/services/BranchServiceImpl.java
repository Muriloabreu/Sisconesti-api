package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisconesti.api.models.BranchModel;
import com.sisconesti.api.repositories.BranchRepository;

import jakarta.transaction.Transactional;

@Service
public class BranchServiceImpl implements BranchService{
	
	@Autowired
	BranchRepository branchRepository;

	@Override
	public List<BranchModel> findAll() {
		
		return branchRepository.findAll();
	}

	@Override
	public Optional<BranchModel> findById(Long id) {
		
		return branchRepository.findById(id);
	}

	@Override
	@Transactional
	public BranchModel save(BranchModel branch) {
		
		return branchRepository.save(branch);
	}

	@Override
	@Transactional
	public void delete(BranchModel brance) {
		
		branchRepository.delete(brance);
		
	}

	@Override
	public boolean existsByName(String name) {
		
		return branchRepository.existsByName(name);
	}

	@Override
	public boolean existsByCnpj(String cnpj) {
		
		return branchRepository.existsByCnpj(cnpj);
	}

}
