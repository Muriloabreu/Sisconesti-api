package com.sisconesti.api.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.sisconesti.api.dtos.CompanyDtos;
import com.sisconesti.api.models.CompanyModel;
import com.sisconesti.api.projections.CompanyJoinMinProjection;
import com.sisconesti.api.services.CompanyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("financeiro/company")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveCompany(@RequestBody @Valid CompanyDtos companyDtos){
		
		
		if(companyService.existsByCorporateName(companyDtos.getCorporateName())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Corporate Name is already in use!"); 
		}
		if (companyService.existsByFantasyName(companyDtos.getFantasyName())) {

			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Fantasy Name is already in use!");
		}
				
		var companyModel = new CompanyModel();
		BeanUtils.copyProperties(companyDtos, companyModel);
		companyModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));		
		return ResponseEntity.status(HttpStatus.OK).body(companyService.save(companyModel));		
		
	}
	
	@GetMapping
	public ResponseEntity<List<CompanyModel>> getAllCompany(){
		
		return ResponseEntity.status(HttpStatus.OK).body(companyService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneompany(@PathVariable(value = "id") Long id){
		
		Optional<CompanyModel> companyOptional = companyService.findById(id);
		if (!companyOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found. ");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(companyService.findById(id));
	}
	@GetMapping("/search/")
	@ResponseBody
	public ResponseEntity<List<CompanyJoinMinProjection>> findByName(@RequestParam(name = "name") String name) {
		
		List<CompanyJoinMinProjection> companyList = companyService.seacheByName(name);
		
		return new ResponseEntity<List<CompanyJoinMinProjection>>(companyList, HttpStatus.OK);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCompany(@PathVariable(value = "id") Long id) {

		Optional<CompanyModel> companyOptional = companyService.findById(id);
		if (!companyOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found. ");
		}

		companyService.delete(companyOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Company deleted successfully. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCompany(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid CompanyDtos companyDtos) {

		Optional<CompanyModel> companyOptional = companyService.findById(id);
		if (!companyOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found.");
		}
		
		var companyModel = companyOptional.get();
		companyModel.setCorporateName(companyDtos.getCorporateName());
		companyModel.setFantasyName(companyDtos.getFantasyName());
		
		
				
		return ResponseEntity.status(HttpStatus.OK).body(companyService.save(companyModel));
	

	}
	
	
	

}
