package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@SpringBootApplication
public class DemoApplication3 {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}
	@Bean
	public CommandLineRunner printMessageNew() {
		return args->{
			System.out.println("This is print mesage by clr");
		};
	}
	@PostConstruct
	public void printMessage() {
			System.out.println("This is print message of void type");
	}
	@PreDestroy
	public void destroy() {
			System.out.println("This is print message of destroy");
	}
	
}