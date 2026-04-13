package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication2 {
	
	public static final Logger logger=LoggerFactory.getLogger(DemoApplication2.class);
	
	public static void main(String[] args) {
			
		System.out.println("Execute Before");
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("This is my first spring boot program");
		logger.info("This is info message by logger");
		logger.debug("This is debug message by logger");
		logger.error("This is error message by logger");
	}
	
}