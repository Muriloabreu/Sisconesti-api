package com.sisconesti.api.dtos;

import jakarta.validation.constraints.NotBlank;

public class StateDto {
	
	@NotBlank
	private String nameState;
	@NotBlank
	private String sigla;

	public StateDto() {
		
	}

	public StateDto(@NotBlank String nameState, String sigla) {
		
		this.nameState = nameState;
		this.sigla = sigla;
	}

	public String getNameState() {
		return nameState;
	}

	public void setNameState(String nameState) {
		this.nameState = nameState;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}
