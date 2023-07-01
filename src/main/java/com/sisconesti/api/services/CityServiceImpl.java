package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisconesti.api.models.CityModel;
import com.sisconesti.api.repositories.CityRepository;

import jakarta.transaction.Transactional;

@Service
public class CityServiceImpl implements CityService{
	
	@Autowired
	CityRepository cityRepository;

	@Override
	public List<CityModel> findAll() {
		
		return cityRepository.findAll();
	}

	@Override
	public Optional<CityModel> findById(Long id) {
		
		return cityRepository.findById(id);
	}

	@Override
	@Transactional
	public CityModel save(CityModel city) {
		
		return cityRepository.save(city);
	}

	@Override
	@Transactional
	public void delete(CityModel city) {
		cityRepository.delete(city);
		
	}

	@Override
	public boolean existsByName(String name) {
		
		return cityRepository.existsByName(name);
	}

	

	

	
	
	

}
