package com.sisconesti.api.dtos;

import jakarta.validation.constraints.NotBlank;

public class SupplierDto {
	
	@NotBlank
	private String name;

	/* Constructor */
	
	public SupplierDto() {
	}

	public SupplierDto(@NotBlank String name) {
		this.name = name;
	}
	
	/* Accessor Methods */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	

}
