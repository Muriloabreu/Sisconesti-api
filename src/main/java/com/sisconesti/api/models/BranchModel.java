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
@Table(name = "TB_BRANCH")
public class BranchModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String cnpj;
	@ManyToOne
	@JoinColumn(name = "id_city")
	private CityModel city;
	
/* Constructor */
	
	public BranchModel() {
		
	}


	public BranchModel(Long id, String name, String cnpj, CityModel city) {
		
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;		
		this.city = city;
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
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public CityModel getCity() {
		return city;
	}
	public void setCity(CityModel city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "BranchModel [id=" + id + ", name=" + name + ", cnpj=" + cnpj + ", city=" + city + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(city);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BranchModel other = (BranchModel) obj;
		return Objects.equals(city, other.city);
	}


	


	

}
