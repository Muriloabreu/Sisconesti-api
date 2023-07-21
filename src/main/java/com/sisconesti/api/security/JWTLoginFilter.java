package com.sisconesti.api.security;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisconesti.api.models.UserModel;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*ESTABELECE NOSSO GERENCIADOR DE TOKEN*/
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter{
	
	/*Configurando o gerenciador de autenticacao*/
	protected JWTLoginFilter(String url, AuthenticationManager authenticationManager) {
       
		/*Obriga a autenticar a URL*/
		super(new AntPathRequestMatcher(url));
       
       /*Gerenciador de autenticacao*/
       setAuthenticationManager(authenticationManager);
		
	}
	
	/*RETORNA O USER AO PROCESSAR A AUTENTICAÇÃO*/
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		/*PENGANDO O TOKEN PARA VALIDAR*/
		
		UserModel user = new ObjectMapper().
				readValue(request.getInputStream(), UserModel.class);
		
		/*RETORNA O USER LOGIN, SENHA E ACESSO*/	
		return getAuthenticationManager().
				authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPasswordUser()));
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		new JWTTokenAuthenticationService().addAuthentication(response, authResult.getName());
	}

}
