package com.sisconesti.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_EMPLOYEES")
public class EmployeeModel extends PersonModel {

	private static final long serialVersionUID = 1L;
	@Column(nullable = false)
	private String cpf;
	@Column(nullable = false, unique = true, length = 10)
	private String matricula;
	
	
	
	/* Constructor */

	public EmployeeModel() {
	}
	
	public EmployeeModel(String cpf, String matricula) {
		
		this.cpf = cpf;
		this.matricula = matricula;
	}



	/* Accessor Methods */
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "EmployeeModel [cpf=" + cpf + ", matricula=" + matricula + "]";
	}
	
	
	
	
	
	
	
	

}
