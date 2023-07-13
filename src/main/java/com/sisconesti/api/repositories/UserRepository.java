package com.sisconesti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sisconesti.api.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
	
	@Query("select u from UserModel u where u.login = ?1 ")
	UserModel findUserByLogin(String login);

}
