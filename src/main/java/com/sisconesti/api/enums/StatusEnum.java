package com.sisconesti.api.enums;

public enum StatusEnum {
	
	ATIVO("Ativo"),
	INATIVO("Inativo"),
	BACKUP("Backup");
	
	private String descricao;

	private StatusEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	

}
