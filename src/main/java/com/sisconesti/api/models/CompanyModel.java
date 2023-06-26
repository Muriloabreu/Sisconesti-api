package com.sisconesti.api.models;

import java.util.Objects;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_COMPANY")
public class CompanyModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String corporate_name;
	
	@Column(nullable = false)
	private String fantasy_name;
	@Column(nullable = false)
	private String cnpj;
	
	/* Constructor */
	
	public CompanyModel() {
		
	}
	
	public CompanyModel(Long id, String corporate_name, String fantasy_name, String cnpj) {
		
		this.id = id;
		this.corporate_name = corporate_name;
		this.fantasy_name = fantasy_name;
		this.cnpj = cnpj;
	}
	
	
	/* Accessor Methods */


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", corporate_name=" + corporate_name + ", fantasy_name=" + fantasy_name + ", cnpj="
				+ cnpj + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fantasy_name, cnpj, corporate_name, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyModel other = (CompanyModel) obj;
		return Objects.equals(fantasy_name, other.fantasy_name) && Objects.equals(cnpj, other.cnpj)
				&& Objects.equals(corporate_name, other.corporate_name) && Objects.equals(id, other.id);
	}

}
