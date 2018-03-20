package com.akshay.rest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "rest_Employee")
@XmlRootElement(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private int id;
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
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
