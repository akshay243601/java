package com.akshay.spring.boot.started.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "SPRING_BOOT_USER")
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gender;

	@OneToMany(cascade = CascadeType.ALL)
	private List<UserItem> userItems;

	public User() {
	}

	public User(int id, String name, String gender, List<UserItem> userItems) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.userItems = userItems;
	}

	public User(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<UserItem> getUserItems() {
		return userItems;
	}

	public void setUserItems(List<UserItem> userItems) {
		this.userItems = userItems;
	}

}
