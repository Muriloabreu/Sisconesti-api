package com.sisconesti.api.security;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*ESTABELECE NOSSO GERENCIADOR DE TOKEN*/
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter{
	
	/*OBRIGAMOS A AUTENTICAR URL*/
	protected JWTLoginFilter(String url, AuthenticationManager authenticationManager) {
		
		/*OBRIGA A AUTENTICAR A URL*/
		super(new AntPathRequestMatcher(url));
		
		/*GERENCIADOR DE AUTENTICAÇÃO*/
		setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
	
		return null;
	}

}
