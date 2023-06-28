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

import com.sisconesti.api.dtos.StateDto;
import com.sisconesti.api.services.StateService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) /* Serve para permitir que seja acessado de qualquer fonte */
@RequestMapping("/sisconesti/states")
public class StateController {
	
	@Autowired
	StateService stateService;
	
	@PostMapping
	public ResponseEntity<Object> saveState(@RequestBody @Valid StateDto stateDto){
		
		if (stateService.existsByName(stateDto.getNameState())) {

			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Name State is already in use!");
		}
		
		CarModel carModel = new CarModel();
		BeanUtils.copyProperties(carDto, carModel); /*Coverte Dtos para Model*/
		carModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(carService.save(carModel));
	}
	
	@GetMapping
	public ResponseEntity<List<CarModel>>getAllCars(){
		return ResponseEntity.status(HttpStatus.OK).body(carService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneCar(@PathVariable(value = "id") Long id) {

		Optional<CarModel> carOptional = carService.findById(id);

		if (!carOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found. "); /* Mensagem se a School não for encontrado */
		}

		return ResponseEntity.status(HttpStatus.OK).body(carOptional.get());

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCar(@PathVariable(value = "id") Long id) {

		Optional<CarModel> carOptional = carService.findById(id);

		if (!carOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found. "); /* Mensagem se a School não for encontrado */
		}
		
		carService.delete(carOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Class Diary deleted successfully.");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCar(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid CarDto carDto) {

		Optional<CarModel> carOptional = carService.findById(id);

		if (!carOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found. "); /* Mensagem se a School não for encontrado */
		}
		
		var carModel = carOptional.get();
		carModel.setLicensePlateCar(carDto.getLicensePlateCar());
		carModel.setBrandCar(carDto.getBrandCar());
		carModel.setModelCar(carDto.getModelCar());
		carModel.setColorCar(carDto.getColorCar());	
		
		return ResponseEntity.status(HttpStatus.OK).body(carService.save(carModel));

	}

}
