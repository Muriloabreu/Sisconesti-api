package com.sisconesti.api.dtos;

import jakarta.validation.constraints.NotBlank;

public class StateDto {
	
	@NotBlank
	private String name;
	@NotBlank
	private String sigla;

	public StateDto() {
		
	}

	public StateDto(@NotBlank String name, String sigla) {
		
		this.name = name;
		this.sigla = sigla;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}
