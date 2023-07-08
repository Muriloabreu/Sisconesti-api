package com.sisconesti.api.models;

import java.util.List;
import java.util.Objects;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	@OneToMany
	@JoinColumn(name = "company_id")
	private List<BranchModel> branchs;
	
	
	/* Constructor */
	
	public CompanyModel() {
		
	}
	
	public CompanyModel(Long id, String corporate_name, String fantasy_name) {
		
		this.id = id;
		this.corporate_name = corporate_name;
		this.fantasy_name = fantasy_name;
		
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

	@Override
	public String toString() {
		return "CompanyModel [id=" + id + ", corporate_name=" + corporate_name + ", fantasy_name=" + fantasy_name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(corporate_name, fantasy_name, id);
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
		return Objects.equals(corporate_name, other.corporate_name) && Objects.equals(fantasy_name, other.fantasy_name)
				&& Objects.equals(id, other.id);
	}

	
	

}
