package com.akshay.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

	@Bean
	public EmpAddress getEmpAddress1() {
		return new EmpAddress();
	}
	
	@Bean
	public EmpAddress getEmpAddress2() {
		return new EmpAddress();
	}
}
