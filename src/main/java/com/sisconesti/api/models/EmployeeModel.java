package com.sisconesti.api.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_EMPLOYEES")
public class EmployeeModel extends PersonModel {

	
	@Column(nullable = false)
	private String cpf;
	@Column(nullable = false, unique = true, length = 10)
	private String matricula;
	@Column(nullable = false)
	private LocalDateTime registrationDate;
	
	
	/* Constructor */

	public EmployeeModel() {
	}
	
	public EmployeeModel(String cpf, String matricula, LocalDateTime registrationDate) {
		this.cpf = cpf;
		this.matricula = matricula;
		this.registrationDate = registrationDate;
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
	
	
	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "EmployeeModel [cpf=" + cpf + ", matricula=" + matricula + ", registrationDate=" + registrationDate
				+ "]";
	}

	
	
	
	
	
	
	
	

}
