package com.address.services.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.address.services.service.AddressService;

@Configuration
public class AddressConfig {

	@Bean
	public AddressService employeeBean() {
		return new AddressService();
	}

	@Bean
	public ModelMapper modelMapperBean() {
		return new ModelMapper();
	}
}
