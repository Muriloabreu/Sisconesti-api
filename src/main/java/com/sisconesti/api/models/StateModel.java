package com.sisconesti.api.models;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "TB_STATES")
public class StateModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nameState;
	@Column(nullable = false)
	private String sigla;
	@Column(nullable = false)
	private LocalDateTime registrationDate;
	
	/* Constructor */
	
	
	public StateModel() {
		
	}
	
	public StateModel(Long id, String nameState, String sigla, LocalDateTime registrationDate) {
		super();
		this.id = id;
		this.nameState = nameState;
		this.sigla = sigla;
		this.registrationDate = registrationDate;
	}
	
	/* Accessor Methods */			

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "StateModel [id=" + id + ", nameState=" + nameState + ", sigla=" + sigla + ", registrationDate="
				+ registrationDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nameState, registrationDate, sigla);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StateModel other = (StateModel) obj;
		return Objects.equals(id, other.id) && Objects.equals(nameState, other.nameState)
				&& Objects.equals(registrationDate, other.registrationDate) && Objects.equals(sigla, other.sigla);
	}
	
	
	
	
	
	
	
	

}
