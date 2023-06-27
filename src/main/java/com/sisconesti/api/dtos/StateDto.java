package com.sisconesti.api.dtos;

import jakarta.validation.constraints.NotBlank;

public class StateDto {
	
	@NotBlank
	private String nameState;

	public StateDto() {
		
	}

	public StateDto(@NotBlank String nameState) {
		super();
		this.nameState = nameState;
	}

	public String getNameState() {
		return nameState;
	}

	public void setNameState(String nameState) {
		this.nameState = nameState;
	}
	
	
	
}
