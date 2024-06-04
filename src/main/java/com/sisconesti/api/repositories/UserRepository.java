package com.sisconesti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sisconesti.api.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
	
	
	UserModel findByLogin(String login);

}
