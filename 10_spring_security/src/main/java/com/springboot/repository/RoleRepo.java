package com.springboot.repository;

import org.springframework.stereotype.Repository;

import com.springboot.entity.Role;

@Repository
public interface RoleRepo {
	
	public Role findByName(String name);
}
