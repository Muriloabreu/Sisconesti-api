package com.sisconesti.api.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

/*FILTRO ONDE TODAS AS REQUISIÇÕES SERÃO CAPTURADAS PARA AUTENTICAR*/
public class JWTAPIAutheticationFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		/*ESTABELECE AUTENTICAÇÃO PARA REQUISIÇÃO*/
		Authentication authentication = new JWTTokenAuthenticationService().
				getAuthentication((HttpServletRequest)request);
		
		/*INSERE O PROCESSO DE AUTENTICAÇÃO  NO SPRING SECURITY*/
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		/*CONTINUA O PROCESSO*/
		chain.doFilter(request, response);
		
		
		
		
		
		
	}

}
