package com.sisconesti.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sisconesti.api.models.UserModel;
import com.sisconesti.api.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		/*Consulta no Banco o user*/
		
		UserModel userModel = userRepository.findUserByLogin(username);
		if(userModel == null) {
			
			throw new UsernameNotFoundException("User not found. ");
		}
		
		return new User(userModel.getLogin(), userModel.getPassword(), userModel.getAuthorities());
	} 

}
