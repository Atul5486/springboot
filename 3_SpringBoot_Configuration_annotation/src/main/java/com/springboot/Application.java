package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	/*
	 Configuration Annotation:
 		@Configuration
 		@ConfigurationProperties 
 		@Bean
 		@Value
	 */

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
