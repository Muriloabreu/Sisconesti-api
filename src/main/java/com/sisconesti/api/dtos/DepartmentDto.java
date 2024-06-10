package com.sisconesti.api.dtos;

import jakarta.validation.constraints.NotBlank;

public class DepartmentDto {
	
	@NotBlank
	private String name;
	
	/*Constructor*/
	public DepartmentDto() {
	}
	
	public DepartmentDto(@NotBlank String name) {
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
