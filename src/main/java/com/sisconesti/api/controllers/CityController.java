package com.sisconesti.api.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sisconesti.api.dtos.CityDto;
import com.sisconesti.api.dtos.StateDto;
import com.sisconesti.api.models.CityModel;
import com.sisconesti.api.models.StateModel;
import com.sisconesti.api.projections.CityJoinMinProjection;
import com.sisconesti.api.projections.StateJoinMinProjection;
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

			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Name city is already in use!");
		}
		
		CityModel cityModel = new CityModel();
		BeanUtils.copyProperties(cityDto, cityModel); /*Coverte Dtos para Model*/
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cityService.save(cityModel));
	}
	
	@GetMapping
	public ResponseEntity<List<CityModel>>getAllCitys(){
		return ResponseEntity.status(HttpStatus.OK).body(cityService.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneCitu(@PathVariable(value = "id") Long id) {

		Optional<CityModel> cityOptional = cityService.findById(id);

		if (!cityOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("City not found. "); /* Mensagem se a School não for encontrado */
		}

		return ResponseEntity.status(HttpStatus.OK).body(cityOptional.get());

	}
	@GetMapping("/search/")
	@ResponseBody
	public ResponseEntity<List<CityJoinMinProjection>> findByName(@RequestParam(name = "name") String name) {
		
		List<CityJoinMinProjection> cityList = cityService.seacheByName(name);
		
		return new ResponseEntity<List<CityJoinMinProjection>>(cityList, HttpStatus.OK);

	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCity(@PathVariable(value = "id") Long id) {

		Optional<CityModel> cityOptional = cityService.findById(id);

		if (!cityOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("City not found. "); /* Mensagem se a School não for encontrado */
		}
		
		cityService.delete(cityOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("City deleted successfully.");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateState(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid CityDto cityDto) {

		Optional<CityModel> cityOptional = cityService.findById(id);

		if (!cityOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("City not found. "); /* Mensagem se a School não for encontrado */
		}
		
		var cityModel = cityOptional.get();
		cityModel.setName(cityDto.getName());
		cityModel.setState(cityDto.getState());
		
		
		return ResponseEntity.status(HttpStatus.OK).body(cityService.save(cityModel));

	}
	
	

}
