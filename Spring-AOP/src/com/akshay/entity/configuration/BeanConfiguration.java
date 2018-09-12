package com.akshay.entity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.akshay.entity.EmpAddress;

@Configuration
public class BeanConfiguration {

	public EmpAddress getEmpAddress1() {
		return new EmpAddress();
	}
	
	@Bean
	public EmpAddress getEmpAddress2() {
		return new EmpAddress();
	}
}
