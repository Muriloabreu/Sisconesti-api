package com.sisconesti.api.services;

import com.sisconesti.api.dtos.AuthDto;

public interface AutenticacaoService {
	
	public String obterToken(AuthDto authDto); 
	
	public String validaTokenJwt(String token);

}
