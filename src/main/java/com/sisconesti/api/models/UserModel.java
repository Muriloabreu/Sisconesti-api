package com.sisconesti.api.models;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_USERS")
public class UserModel implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String login;
	
	private String passwordUser;
	
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", uniqueConstraints = @UniqueConstraint(
			columnNames = {"user_id", "role_id"}, name = "unique_role_user" ),
	joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", table = "tb_user", 
	foreignKey = @ForeignKey(name = "user_fk", value = ConstraintMode.CONSTRAINT)),
	
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", table = "tb_role",
			foreignKey = @ForeignKey(name = "role_fk", value = ConstraintMode.CONSTRAINT)) )
	private List<Role> roles; /* PAPEIS, ACESSOS*/

	
	public UserModel() {		
	}
		
	public UserModel(Long id, String login, String passwordUser, String name) {
		
		this.id = id;
		this.login = login;
		this.passwordUser = passwordUser;
		this.name = name;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* São acessos de User ROLE_ADM, ROLE_GERENTE  */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { 
		
		return null;
	}
	@Override
	public String getPassword() {
		return this.passwordUser;
	}
	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	

}
