package com.akshay.spring.boot.started.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "SPRING_BOOT_ITEM")
@Entity
public class UserItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String code;
	private String name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private User user;

	public UserItem() {

	}
	public UserItem(int id, String code, String name, String userName) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.user = new User(userName, "");
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
