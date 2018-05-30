package com.akshay.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	@Value("2")
	private int id;
	
	@Value("Akshay")
	private String name;
	
	@Autowired //As autowired here no need to define address mapping with employee in application context.
	@Qualifier("empAddress1")   //in application-context we have two empAddress type. So it will confused. So use qualifier to tell which exact bean we need to wire
	private Address address;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
