package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("This is my first spring boot program");
	}
	
	@Bean
	@Order(9)
	public CommandLineRunner printMessage() {
		return args->{
			System.out.println("This is print message form clr");
		};
	}
	
	@Bean
	@Order(10)
	public CommandLineRunner printMessage1() {
		return args->{
			System.out.println("This is print message from clr 1");
		};
	}

}