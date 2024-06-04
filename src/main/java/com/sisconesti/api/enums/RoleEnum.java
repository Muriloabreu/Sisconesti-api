package com.sisconesti.api.enums;

public enum RoleEnum {
	
	ADMIN("Admin"),
	USER("User");
	
	
	private String role;

	private RoleEnum(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}

}
