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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="user_form")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
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
	
}
