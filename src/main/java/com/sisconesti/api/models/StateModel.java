package com.sisconesti.api.models;

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
	
	/* Constructor */
	
	
	public StateModel() {
		
	}
	public StateModel(Long id, String nameState) {
		super();
		this.id = id;
		this.nameState = nameState;
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
	
	@Override
	public String toString() {
		return "StateModel [id=" + id + ", nameState=" + nameState + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, nameState);
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
		return Objects.equals(id, other.id) && Objects.equals(nameState, other.nameState);
	}
	
	
	
	

}
