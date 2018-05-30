package com.akshay.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("empAddress1")   //by default it take like : Address address = new Address() -> @Component("address")  --> Address is by default address. We can specify name as well, @Component("empAddress1")
public class Address {

	@Value("1")
	private int id;
	@Value("Gali No. 2")
	private String street;
	@Value("Noida")
	private String city;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
