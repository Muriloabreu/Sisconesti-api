package com.sisconesti.api.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.sisconesti.api.dtos.DepartmentDto;
import com.sisconesti.api.models.DepartmentModel;
import com.sisconesti.api.services.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("sisconesti/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<Object> saveDepartment(@RequestBody @Valid DepartmentDto departmentDto){
		
		if(departmentService.existsByName(departmentDto.getName())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Name department is already in use!"); 
		}
				
		var departmentModel = new DepartmentModel();
		BeanUtils.copyProperties(departmentDto, departmentModel);
		
		return ResponseEntity.status(HttpStatus.OK).body(departmentService.save(departmentModel));		
		
	}
	
	@GetMapping
	public ResponseEntity<List<DepartmentModel>> getAllDepartments(){
		
		return ResponseEntity.status(HttpStatus.OK).body(departmentService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneDepartment(@PathVariable(value = "id") Long id){
		
		Optional<DepartmentModel> departmentOptional = departmentService.findById(id);
		if (!departmentOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found. ");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(departmentService.findById(id));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteDepartment(@PathVariable(value = "id") Long id) {

		Optional<DepartmentModel> departmentOptional = departmentService.findById(id);
		if (!departmentOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found. ");
		}

		departmentService.delete(departmentOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Department deleted successfully. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateDepartment(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid DepartmentDto departmentDto) {

		Optional<DepartmentModel> departmentOptional = departmentService.findById(id);
		if (!departmentOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found. ");
		}
		
		var departmenthModel = departmentOptional.get();
		departmenthModel.setName(departmentDto.getName());
		
		return ResponseEntity.status(HttpStatus.OK).body(departmentService.save(departmenthModel));
	

	}

}
