package com.sisconesti.api.dtos;



import com.sisconesti.api.models.CityModel;

import jakarta.validation.constraints.NotBlank;


public class BranchDtos {
	
	
	@NotBlank
	private String name;
	@NotBlank
	private String cnpj;
	@NotBlank
	private CityModel city;
	
	
	/* Constructor */
	
	public BranchDtos() {
		super();
	}
	public BranchDtos(@NotBlank String name, @NotBlank String cnpj, @NotBlank CityModel city) {
		super();
		this.name = name;
		this.cnpj = cnpj;
		this.city = city;
	}


	/* Accessor Methods */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpf(String cnpj) {
		this.cnpj = cnpj;
	}
	public CityModel getCity() {
		return city;
	}
	public void setCity(CityModel city) {
		this.city = city;
	}
	
	
	

}
