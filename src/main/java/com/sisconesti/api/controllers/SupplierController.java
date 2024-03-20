package com.sisconesti.api.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
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
import org.springframework.web.bind.annotation.RestController;


import com.sisconesti.api.dtos.SupplierDto;

import com.sisconesti.api.models.SupplierModel;
import com.sisconesti.api.services.SupplierService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) /* Serve para permitir que seja acessado de qualquer fonte */
@RequestMapping("/sisconesti/suppliers")
public class SupplierController {
	
	@Autowired
	SupplierService supplierService;
	
	@PostMapping
	public ResponseEntity<Object> saveSupplier(@RequestBody @Valid SupplierDto supplierDto){
		
		if(supplierService.existsByName(supplierDto.getName())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Name supplier is already in use!"); 
		}
						
		var supplierModel = new SupplierModel();
		BeanUtils.copyProperties(supplierDto, supplierModel);
		supplierModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		
		return ResponseEntity.status(HttpStatus.OK).body(supplierService.save(supplierModel));		
		
	}
	
	@GetMapping
	public ResponseEntity<List<SupplierModel>> getAllSupplier(){
		
		return ResponseEntity.status(HttpStatus.OK).body(supplierService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneSupplier(@PathVariable(value = "id") Long id){
		
		Optional<SupplierModel> supplierOptional = supplierService.findById(id);
		if (!supplierOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier not found. ");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(supplierService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteSupplier(@PathVariable(value = "id") Long id) {

		Optional<SupplierModel> supplierOptional = supplierService.findById(id);
		if (!supplierOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier not found. ");
		}

		supplierService.delete(supplierOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Supplier deleted successfully. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateSupplier(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid SupplierDto supplierDto) {

		Optional<SupplierModel> supplierOptional = supplierService.findById(id);
		if (!supplierOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier not found. ");
		}
		
		var supplierModel = new SupplierModel();
		supplierModel.setName(supplierDto.getName());		
				
		return ResponseEntity.status(HttpStatus.OK).body(supplierService.save(supplierModel));
	

	}
	

}
