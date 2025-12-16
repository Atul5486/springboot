package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Components.AppComponent;
import com.springboot.repository.AppRepository;

@Service
public class AppService{
	
	private AppComponent comp;
	private AppRepository repo;
	
	@Autowired
	public AppService(AppComponent comp,AppRepository repo) {
		this.comp=comp;
		this.repo=repo;
		allService();
	}
	
	
	public void allService() {
		System.out.println("This is all service\n");
		System.out.println("This is comp");
		comp.printComp();
		System.out.println("\nThis is repo");
		repo.printRepo();
	}
	
}