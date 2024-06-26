package com.sisconesti.api.models;


import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_DEPARTMENTS")
public class DepartmentModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	
	
	/* Constructor */
	public DepartmentModel() {
		
	}

	public DepartmentModel(Long id, String name) {
		this.id = id;
		this.name = name;
		
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

	@Override
	public String toString() {
		return "DepartmentModel [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentModel other = (DepartmentModel) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
	
	
	
	

}
