package com.smartcity;
// This defines the base package of your application.
// Spring Boot will scan this package and all its sub-packages
// (controller, entity, repository, etc.)

import org.springframework.boot.SpringApplication;
// Used to start the Spring Boot application.

import org.springframework.boot.autoconfigure.SpringBootApplication;
// This is a very important annotation.
// It enables auto-configuration and component scanning.

@SpringBootApplication
// This is actually a combination of 3 annotations:
// 1) @Configuration
// 2) @EnableAutoConfiguration
// 3) @ComponentScan
//
// It tells Spring Boot:
// - Configure everything automatically
// - Scan this package and sub-packages
// - Start the application

public class SmartCityBackendApplication {

	public static void main(String[] args) {
		// This is the entry point of the Java program.
		// When you click "Run", execution starts here.

		SpringApplication.run(SmartCityBackendApplication.class, args);
		// This line:
		// 1) Starts embedded Tomcat server
		// 2) Connects to database
		// 3) Loads entities and repositories
		// 4) Starts the entire Spring context
	}
}