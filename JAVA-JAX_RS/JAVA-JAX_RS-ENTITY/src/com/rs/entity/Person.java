package com.rs.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	public String Email;
	public String Password;
	public String MobileNo;
	public String Name;

	
	
	public String getEmail() {
		return Email;
	}

	public String getPassword() {
		return Password;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public String getName() {
		return Name;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

	public void setName(String name) {
		Name = name;
	}

}
