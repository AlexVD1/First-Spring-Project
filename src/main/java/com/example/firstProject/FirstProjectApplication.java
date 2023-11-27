package com.example.firstProject;

import com.example.controller.UserRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = UserRestController.class)
@ComponentScan("com.example")//to scan repository files
@EnableJpaRepositories("com.example") //Scan JPA Repositories
@EntityScan("com.example.models")//Scan for entitiy models
public class FirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}

}
