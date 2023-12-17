package com.employee.services.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.employee.services.service.EmployeeService;

@Configuration
public class EmployeeConfig {

//	@Bean
//	public EmployeeService employeeBean() {
//		return new EmployeeService();
//	}

	@Bean
	public ModelMapper modelMapperBean() {
		return new ModelMapper();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
