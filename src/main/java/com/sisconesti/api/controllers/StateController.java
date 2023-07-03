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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.sisconesti.api.dtos.StateDto;
import com.sisconesti.api.models.StateModel;
import com.sisconesti.api.projections.StateJoinMinProjection;
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
		
		if (stateService.existsByNameState(stateDto.getNameState())) {

			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Name State is already in use!");
		}
		
		StateModel stateModel = new StateModel();
		BeanUtils.copyProperties(stateDto, stateModel); /*Coverte Dtos para Model*/
		stateModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(stateService.save(stateModel));
	}
	
	@GetMapping
	public ResponseEntity<List<StateModel>>getAllStates(){
		return ResponseEntity.status(HttpStatus.OK).body(stateService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneState(@PathVariable(value = "id") Long id) {

		Optional<StateModel> stateOptional = stateService.findById(id);

		if (!stateOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("State not found. "); /* Mensagem se a School não for encontrado */
		}

		return ResponseEntity.status(HttpStatus.OK).body(stateOptional.get());

	}
	@GetMapping("/search/")
	@ResponseBody
	public ResponseEntity<List<StateJoinMinProjection>> findByName(@RequestParam(name = "name") String name) {
		
		List<StateJoinMinProjection> stateList = stateService.seacheByName(name);
		
		return new ResponseEntity<List<StateJoinMinProjection>>(stateList, HttpStatus.OK);

	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteState(@PathVariable(value = "id") Long id) {

		Optional<StateModel> stateOptional = stateService.findById(id);

		if (!stateOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("State not found. "); /* Mensagem se a School não for encontrado */
		}
		
		stateService.delete(stateOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("State deleted successfully.");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateState(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid StateDto stateDto) {

		Optional<StateModel> stateOptional = stateService.findById(id);

		if (!stateOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("State not found. "); /* Mensagem se a School não for encontrado */
		}
		
		var stateModel = stateOptional.get();
		stateModel.setNameState(stateDto.getNameState());
		stateModel.setSigla(stateDto.getSigla());
		
		
		return ResponseEntity.status(HttpStatus.OK).body(stateService.save(stateModel));

	}

}
