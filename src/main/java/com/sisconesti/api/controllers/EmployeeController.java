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
import org.springframework.web.bind.annotation.RestController;

import com.sisconesti.api.dtos.DepartmentDto;
import com.sisconesti.api.dtos.EmployeeDto;
import com.sisconesti.api.models.DepartmentModel;
import com.sisconesti.api.models.EmployeeModel;
import com.sisconesti.api.services.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("sisconesti/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Object> saveDepartment(@RequestBody @Valid EmployeeDto employeeDto){
		
		if(employeeService.existsByCpf(employeeDto.getCpf())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: CPF is already in use!"); 
		}
		if (employeeService.existsByMatricula(employeeDto.getMatricula())) {

			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Matricula is already in use!");
		}
				
		var employee = new EmployeeModel();
		BeanUtils.copyProperties(employeeDto, employee);
		employee.setRegistrationDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.save(employee));		
		
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeModel>> getAllEmployees(){
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneEmployee(@PathVariable(value = "id") Long id){
		
		Optional<EmployeeModel> employeeOptional = employeeService.findById(id);
		if (!employeeOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found. ");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable(value = "id") Long id) {

		Optional<EmployeeModel> employeeOptional = employeeService.findById(id);
		if (!employeeOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found. ");
		}

		employeeService.delete(employeeOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid EmployeeDto employeeDto) {

		Optional<EmployeeModel> employeeOptional = employeeService.findById(id);
		if (!employeeOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found. ");
		}
		var employeeModel = employeeOptional.get();
		
		employeeModel.setFirstName(employeeDto.getFirstName());
		employeeModel.setLastName(employeeDto.getLastName());
		employeeModel.setTelephone(employeeDto.getTelephone());
		employeeModel.setPersonType(employeeDto.getPersonType());
		employeeModel.setEmail(employeeDto.getEmail());
		employeeModel.setMatricula(employeeDto.getMatricula());
		employeeModel.setCpf(employeeDto.getCpf());		
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.save(employeeModel));
	

	}

}
