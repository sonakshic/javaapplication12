package com.example.javaentity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sona")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long id;

	@Column(name = "firstname")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "users_role", joinColumns = 
//	@JoinColumn(name = "user_id", referencedColumnName = "id"), 
//	inverseJoinColumns = @JoinColumn(name = "role_id", 
//	referencedColumnName = "id"))
//	Set<Role> roles = new HashSet<Role>();

//	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
//	@JoinTable(name = "users_rolee", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
//	inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
//	private List<Role> roles = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_rolee", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "emp_id"))

//	private List<Role> roles = new ArrayList<>();

	private Set<Role> roles = new HashSet<>();

	public Users() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
//
//	public List<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

//	public Set<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}

}
