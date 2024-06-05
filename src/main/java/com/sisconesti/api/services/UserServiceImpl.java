package com.sisconesti.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sisconesti.api.models.UserModel;
import com.sisconesti.api.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserModel> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<UserModel> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	@Transactional
	public UserModel salvar(UserModel userModel) {
		return userRepository.save(userModel);
	}

	@Override
	@Transactional
	public void excluir(UserModel userModel) {
		userRepository.delete(userModel);
	}

	@Override
	public UserModel findByLogin(String login) {
		return userRepository.findByLogin(login);
	}

	@Override
	public UserDetails loadUserByUsername(String login) {
		return userRepository.findByLogin(login);
	}

	

}
