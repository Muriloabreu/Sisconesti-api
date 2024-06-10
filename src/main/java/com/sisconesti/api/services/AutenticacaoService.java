package com.sisconesti.api.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sisconesti.api.dtos.AuthDto;

public interface AutenticacaoService extends UserDetailsService{
	
	public String obterToken(AuthDto authDto); 
	
	public String validaTokenJwt(String token);

}
