package com.sisconesti.api.dtos;

import jakarta.validation.constraints.NotBlank;

public class StateDto {
	
	@NotBlank
	private String name;
	@NotBlank
	private String uf;

	public StateDto() {		
	}
	public StateDto(@NotBlank String name, String uf) {		
		this.name = name;
		this.uf = uf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
}
