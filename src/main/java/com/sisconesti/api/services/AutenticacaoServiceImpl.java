package com.sisconesti.api.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.sisconesti.api.dtos.AuthDto;
import com.sisconesti.api.models.UserModel;
import com.sisconesti.api.repositories.UserRepository;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		return userRepository.findByLogin(login);
	}

	@Override
	public String obterToken(AuthDto authDto) {
		UserModel usuario = userRepository.findByLogin(authDto.getLogin());

		return geraTokenJwt(usuario);
	}

	public String geraTokenJwt(UserModel usuario) {

		try {

			Algorithm algorithm = Algorithm.HMAC256("my-secret");

			String token = JWT.create()
					.withIssuer("auth-api")
					.withSubject(usuario.getLogin())
					.withExpiresAt(geraDataExpiracao())
					.sign(algorithm);

			return token;

		} catch (JWTCreationException exception) {

			throw new RuntimeException("Erro ao tentar gerar o token!" + exception.getMessage());
		}

	}

	public String validaTokenJwt(String token) {

		try {

			Algorithm algorithm = Algorithm.HMAC256("my-secret");

			return JWT.require(algorithm)
					.withIssuer("auth-api")
					.build().verify(token)
					.getSubject();

		} catch (JWTVerificationException exception) {

			return "";
		}
	}

	private Instant geraDataExpiracao() {

		return LocalDateTime.now().plusHours(24).toInstant(ZoneOffset.of("-03:00"));
	}

}
