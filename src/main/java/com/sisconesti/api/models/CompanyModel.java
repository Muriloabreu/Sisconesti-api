package com.sisconesti.api.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String corporateName;	
	@Column(nullable = false)
	private String fantasyName;
	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "company_id")
	private List<BranchModel> branchs;
	@Column(nullable = false)
	private LocalDateTime registrationDate;
	
	
	/* Constructor */
	
	public CompanyModel() {
		
	}
	public CompanyModel(Long id, String corporateName, String fantasyName, List<BranchModel> branchs,
			LocalDateTime registrationDate) {
		this.id = id;
		this.corporateName = corporateName;
		this.fantasyName = fantasyName;
		this.branchs = branchs;
		this.registrationDate = registrationDate;
	}

	/* Accessor Methods */


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getCorporateName() {
		return corporateName;
	}
	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}
	public String getFantasyName() {
		return fantasyName;
	}
	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}
	public List<BranchModel> getBranchs() {
		return branchs;
	}
	public void setBranchs(List<BranchModel> branchs) {
		this.branchs = branchs;
	}
	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
	@Override
	public String toString() {
		return "CompanyModel [id=" + id + ", corporateName=" + corporateName + ", fantasyName=" + fantasyName
				+ ", branchs=" + branchs + ", registrationDate=" + registrationDate + "]";
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
		CompanyModel other = (CompanyModel) obj;
		return Objects.equals(id, other.id);
	}

	

	

	

	
	

}
