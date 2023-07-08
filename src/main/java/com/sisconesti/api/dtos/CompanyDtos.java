package com.sisconesti.api.dtos;

import jakarta.validation.constraints.NotBlank;

public class CompanyDtos {
	
	@NotBlank
	private String corporate_name;
	@NotBlank
	private String fantasy_name;
	
	/* Constructor */
	
	public CompanyDtos() {
		
	}

	public CompanyDtos(@NotBlank String corporate_name, @NotBlank String fantasy_name) {
		
		this.corporate_name = corporate_name;
		this.fantasy_name = fantasy_name;
		
	}
	
	/* Accessor Methods */

	public String getCorporate_name() {
		return corporate_name;
	}

	public void setCorporate_name(String corporate_name) {
		this.corporate_name = corporate_name;
	}

	public String getfantasy_name() {
		return fantasy_name;
	}

	public void setfantasy_name(String fantasy_name) {
		this.fantasy_name = fantasy_name;
	}

	

	
	
	
	
}
