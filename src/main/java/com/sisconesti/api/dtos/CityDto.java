package com.sisconesti.api.dtos;

import com.sisconesti.api.models.StateModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CityDto {
	
	@NotBlank
	private String name;
	@NotNull
	private StateModel state;
	
	/*Constructor*/
	
	public CityDto() {
		
	}

	public CityDto(@NotBlank String name, @NotNull StateModel state) {
		super();
		this.name = name;
		this.state = state;
	}

	/* Accessor Methods */
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StateModel getState() {
		return state;
	}

	public void setState(StateModel state) {
		this.state = state;
	}
	
	

}
