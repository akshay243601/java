package com.akshay.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Student_Spring")
public class Student 
{
	@Id @GeneratedValue//(strategy = GenerationType.AUTO)
	private int id;
	
	private String studentName;
	
	private int age;

	private String email;
	
	private String password;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;
	
	private String company;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getStudentName() 
	{
		return studentName;
	}

	public void setStudentName(String studentName) 
	{
		this.studentName = studentName;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
