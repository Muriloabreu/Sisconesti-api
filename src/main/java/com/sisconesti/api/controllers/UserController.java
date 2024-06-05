package com.sisconesti.api.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sisconesti.api.dtos.UserDto;
import com.sisconesti.api.models.UserModel;
import com.sisconesti.api.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("sisconesti/usuarios")
@CrossOrigin(originPatterns = "*", maxAge = 3600) /* Para permitir ser acessado de qualquer fonte */
public class UserController {
	
	
	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping
	public ResponseEntity<Object> salvarUser(@RequestBody @Valid UserDto userDto) {

		UserModel usuarioExist = userService.findByLogin(userDto.getLogin());

		if (usuarioExist != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Login is already in use!");
		}
		/* Criptografia de senha para salvar no banco */
		var passwordHash = passwordEncoder.encode(userDto.getSenha());

		UserModel usuarioModel = new UserModel();
		BeanUtils.copyProperties(userDto, usuarioModel); /* Coverte Dtos para Model */

		usuarioModel.setSenha(passwordHash);

		return ResponseEntity.status(HttpStatus.CREATED).body(userService.salvar(usuarioModel));
	}

	@GetMapping("/admin")
	public String getAdmin() {
		return "Permissão de ADM";
	}

	@GetMapping("/user")
	public String getUser() {
		return "Permissão de User";
	}

}
