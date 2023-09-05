package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisconesti.api.models.CompanyModel;
import com.sisconesti.api.projections.CompanyJoinMinProjection;
import com.sisconesti.api.repositories.CompanyRepository;

import jakarta.transaction.Transactional;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;
	
	
	@Override
	public List<CompanyModel> findAll() {
		
		return companyRepository.findAll();
	}

	@Override
	public Optional<CompanyModel> findById(Long id) {
		
		return companyRepository.findById(id);
	}

	@Override
	@Transactional
	public CompanyModel save(CompanyModel company) {
		
		return companyRepository.save(company);
	}

	@Override
	@Transactional
	public void delete(CompanyModel company) {
		
		companyRepository.delete(company);
		
	}

	@Override
	public boolean existsByCorporateName(String name) {
		
		return companyRepository.existsByCorporateName(name);
	}

	@Override
	public boolean existsByFantasyName(String name) {
		
		return companyRepository.existsByFantasyName(name);
	}

	@Override
	public List<CompanyJoinMinProjection> seacheByName(String name) {
		
		return companyRepository.seacheByNameCompany(name);
	}
	
	

	

	
}
