package com.imaginnovate.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class EmployeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeManagementApplication.class, args);
		System.out.println("go");
	}
	
	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}

}
