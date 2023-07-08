package com.sisconesti.api.dtos;

import jakarta.validation.constraints.NotBlank;

public class CompanyDtos {
	
	@NotBlank
	private String corporateName;
	@NotBlank
	private String fantasyName;
	
	/* Constructor */
	
	public CompanyDtos() {
		
	}

	public CompanyDtos(@NotBlank String corporateName, @NotBlank String fantasyName) {
		super();
		this.corporateName = corporateName;
		this.fantasyName = fantasyName;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}



	/* Accessor Methods */

	

	

	
	
	
	
}
