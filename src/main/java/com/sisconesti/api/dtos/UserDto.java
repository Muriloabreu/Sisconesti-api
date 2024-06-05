package com.sisconesti.api.dtos;

import com.sisconesti.api.enums.RoleEnum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserDto {
	
	/*Validação dos campos*/
	@NotBlank
	private String nome;
	@NotBlank
	private String login;
	@NotBlank
	private String senha;
	@NotNull
	private RoleEnum role;
	
	public UserDto() {
	}

	public UserDto(@NotBlank String nome, @NotBlank String login, @NotBlank String senha, RoleEnum role) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.role = role;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}
	
	
	
	
	
	

}
