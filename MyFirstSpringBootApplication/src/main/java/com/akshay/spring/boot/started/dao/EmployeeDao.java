package com.akshay.spring.boot.started.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.akshay.spring.boot.started.entity.User;

@Repository
public class EmployeeDao {

	public static List<User> users = null;
	static{
		users = new ArrayList<>(Arrays.asList(
				new User(1, "Akshay", "MALE"), 
				new User(2, "Rachit", "MALE"),
				new User(3, "Sameer", "MALE")));
	}
	
	public List<User> listUsers() {
		return users;
	}
	
	public boolean addUser(User user) {
		users.add(user);
		return true;
	}

	public User findUser(int id) {
		return users.stream().filter(x -> x.getId() == id).findFirst().get();
	}

	public boolean updateUser(User user, int id) {
		for(int i = 0; i < users.size(); i++){
			User userObj = users.get(i);
			if(userObj.getId() == id){
				users.set(i,user);
				return true;
			}
		}
		return false;
	}
}
