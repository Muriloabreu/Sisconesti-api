package com.sisconesti.api.dtos;

import com.sisconesti.api.models.StateModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CityDto {
	
	@NotBlank
	private String nameCity;
	@NotNull
	private StateModel state;
	
	/*Constructor*/
	
	public CityDto() {
		
	}

	public CityDto(@NotBlank String nameCity, @NotNull StateModel state) {
		super();
		this.nameCity = nameCity;
		this.state = state;
	}

	/* Accessor Methods */
	
	
	public String getNameCity() {
		return nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

	public StateModel getState() {
		return state;
	}

	public void setState(StateModel state) {
		this.state = state;
	}
	
	

}
