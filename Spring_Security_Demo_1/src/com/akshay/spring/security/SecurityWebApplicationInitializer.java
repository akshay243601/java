package com.akshay.spring.security;

import java.util.TreeMap;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	public SecurityWebApplicationInitializer(){
		super(WebSecurityConfig.class);

	}
}