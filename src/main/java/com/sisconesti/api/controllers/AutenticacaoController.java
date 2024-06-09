package com.sisconesti.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sisconesti.api.dtos.AuthDto;
import com.sisconesti.api.services.AutenticacaoService;

@RestController
@RequestMapping("/sisconesti/usuarios/auth")
public class AutenticacaoController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public String auth(@RequestBody AuthDto authDto ) {
		
		var usuarioAutenticationToken = new UsernamePasswordAuthenticationToken(authDto.getLogin(), authDto.getSenha());
		authenticationManager.authenticate(usuarioAutenticationToken);
		
		return autenticacaoService.obterToken(authDto);
	}

}
