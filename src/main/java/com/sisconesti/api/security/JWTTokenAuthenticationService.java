package com.sisconesti.api.security;

import java.sql.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.sisconesti.api.ApplicationContextLoad;
import com.sisconesti.api.models.UserModel;
import com.sisconesti.api.repositories.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class JWTTokenAuthenticationService {
	
	/*VALIDADE DE DOIS DIAS DO TOKEN*/
	private static final long EXPIRATION_TIME = 172800000;
	
	/*SENHA UNICA PARA COMPOR A AUTENTICAÇÃO*/
	private static final String SECRET = "*-dlpobwa-!-*/4/<!@\26789-*--9/esT";
	
	/*PREFIXO PADRÃO DE TOKEN */
	private static final String TOKEN_PREFIX = "Bearer";
	
	/**/
	private static final String HEARD_STRING = "Authorization";
	
	/*GERANDO TOKEN DE AUTENTICAÇÃO ADICIONANDO AO CABEÇALHO E RESPOSTA Http*/
	public void addAuthentication(HttpServletResponse response, String username)throws Exception {
		
		/*MONTAGEM DO TOKEN*/
		String JWT = Jwts.builder() /*CHAMA O GERADOR DE TOKEN	*/
				.setSubject(username) /*ADD USUÁRIO*/
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) /*TEMPO DE EXPIRAÇÃO*/
				.signWith(SignatureAlgorithm.HS512,SECRET).compact(); /*COMPACTAÇÃO E ALGORITMO DE GERAÇÃO DE SENHA*/
		
		/*JUNTA TOKEN COM O PREFIXO*/
		String token = TOKEN_PREFIX + " " + JWT; /*Bearer + TOKEN*/
		
		/*ADD CABEÇALHO Http*/
		response.addHeader(HEARD_STRING, token);/*Authorization: Bearer + TOKEN*/
		
		/*ESCREVE TOKEN COMO RESPOSTA DO CORPO Http*/
		response.getWriter().write("{\"Authorization\": \""+token+"\"}");
		
	}
	
	/*RETORNA USER VALIDADO COM TOKEN OU CASO NÃO SEJA VALIDO RETORNA NULL*/
	public Authentication getAuthentication(HttpServletRequest request) {
		
		/*PEGA O TOKEN ENVIADO NO CABEÇALHP Http*/
		String token = request.getHeader(HEARD_STRING);
		if(token != null) {
			/*FAZ A VALIDAÇÃO DO TOKEN DO USUÁRIO*/
			String user = Jwts.parser().setSigningKey(SECRET) /*Bearer + TOKEN*/
						 .parseClaimsJws(token.replace(TOKEN_PREFIX, "")) /* TOKEN*/
						 .getBody().getSubject(); /*USER*/
			
			if(user != null) {
				
				UserModel userModel = ApplicationContextLoad.getApplicationContext()
							.getBean(UserRepository.class).findUserByLogin(user);
				
				/*RETORNAR USER LOGADO*/
				
			}else {
				return null; /*NÃO AUTORIZADO */
			}
		}else {
			return null; /*NÃO AUTORIZADO */
		}
	}
	
	
	

}
