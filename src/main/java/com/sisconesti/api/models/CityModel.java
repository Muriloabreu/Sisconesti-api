package com.sisconesti.api.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CITYS")
public class CityModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	@ManyToOne
	@JoinColumn(nullable = false)
	private StateModel state;
	
	/* Constructor */
	
	
	public CityModel() {
		
	}

	public CityModel(Long id, String name, StateModel state) {
	
		this.id = id;
		this.name = name;
		this.state = state;
	}
	
	
	/* Accessor Methods */
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StateModel getState() {
		return state;
	}

	public void setState(StateModel state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "CityModel [id=" + id + ", name=" + name + ", state=" + state + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityModel other = (CityModel) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(state, other.state);
	}

	
	
	
	
	
	
	
	

}
