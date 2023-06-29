package com.sisconesti.api.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sisconesti.api.dtos.CityDto;
import com.sisconesti.api.dtos.StateDto;
import com.sisconesti.api.models.CityModel;
import com.sisconesti.api.models.StateModel;
import com.sisconesti.api.services.CityService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) /* Serve para permitir que seja acessado de qualquer fonte */
@RequestMapping("/sisconesti/citys")
public class CityController {
	
	@Autowired
	CityService cityService;
	
	@PostMapping
	public ResponseEntity<Object> saveCity(@RequestBody @Valid CityDto cityDto){
		
		if (cityService.existsByName(cityDto.getName())) {

			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Name State is already in use!");
		}
		
		CityModel cityModel = new CityModel();
		BeanUtils.copyProperties(cityDto, cityModel); /*Coverte Dtos para Model*/
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cityService.save(cityModel));
	}
	
	@GetMapping
	public ResponseEntity<List<CityModel>>getAllCitys(){
		return ResponseEntity.status(HttpStatus.OK).body(cityService.findAll());
	}
	
	
	
	

}
