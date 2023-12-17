package com.employee.services;

// https://www.geeksforgeeks.org/spring-boot-microservices-communication-using-resttemplate-with-example/?ref=ml_lbp
//https://www.geeksforgeeks.org/spring-boot-microservices-communication-using-webclient-with-example/?ref=ml_lbp

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
