package com.springboot.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AppRepository{
	
	public void printRepo() {
		System.out.println("This is called by a repo bean");
	}
}