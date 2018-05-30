package com.akshay.entity;

import org.springframework.beans.factory.annotation.Value;

public class EmpAddress {
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
