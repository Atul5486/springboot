package com.springboot.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;
	@Column
	String username;
	
	@Column
	String password;
	
	
	
	@ManyToMany
	@JoinTable(
			name="role_user",
			joinColumns = @JoinColumn(name="uid"),
			inverseJoinColumns = @JoinColumn(name="rid")
			)
	List<Role> role;



	public int getUid() {
		return uid;
	}



	public void setUid(int uid) {
		this.uid = uid;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public List<Role> getRole() {
		return role;
	}



	public void setRole(List<Role> role) {
		this.role = role;
	}



	public User() {
		super();
	}


	public User(int uid, String username, String password, List<Role> role) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	
}
