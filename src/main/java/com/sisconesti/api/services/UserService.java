package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;

import com.sisconesti.api.models.UserModel;

public interface UserService {
	
	List<UserModel> findAll();
	Optional<UserModel> findById(Long id);
	UserModel salvar(UserModel userModel);
	void excluir(UserModel userModel);
	UserModel findByLogin(String login);
	UserDetails loadUserByUsername(String login);


}
