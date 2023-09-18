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
@Table(name = "TB_SUPPLIER")
public class SupplierModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private LocalDateTime registrationDate;
	
	/* Constructor */
	
	public SupplierModel() {
	}

	public SupplierModel(Long id, String name, LocalDateTime registrationDate ) {
		this.id = id;
		this.name = name;
		this.registrationDate = registrationDate;
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
	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "SupplierModel [id=" + id + ", name=" + name + ", registrationDate=" + registrationDate + "]";
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
		SupplierModel other = (SupplierModel) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}
