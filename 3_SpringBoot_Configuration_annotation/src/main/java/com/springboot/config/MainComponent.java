package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@PropertySource("classpath:application.properties")
public class MainComponent{
	
	private AppComponent appComponent;
	
	@Value("${app.name}")
	String name;
	
	@Autowired
	public MainComponent(AppComponent appComponent) {
		this.appComponent=appComponent;
	}
	 @PostConstruct 
	    public void init() {
	        showMessage();
	    }
	
	public void showMessage() {
		appComponent.printMessage();
		System.out.println("Project name :" +name);
	}
}