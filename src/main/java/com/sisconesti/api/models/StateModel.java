package com.sisconesti.api.models;

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

}
