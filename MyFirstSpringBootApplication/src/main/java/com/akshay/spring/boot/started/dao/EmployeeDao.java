package com.akshay.spring.boot.started.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.akshay.spring.boot.started.entity.User;
import com.akshay.spring.boot.started.respository.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRespository;
	public static List<User> users = null;
	static {
		users = new ArrayList<>(Arrays.asList(new User(1, "Akshay", "MALE"), new User(2, "Rachit", "MALE"),
				new User(3, "Sameer", "MALE")));
	}

	public List<User> listUsers() {

		List<User> users = new ArrayList<>();

		// employeeRespository.findAll().forEach(users::add);
		// or
		Iterator<User> itr = employeeRespository.findAll().iterator();
		while (itr.hasNext()) {
			users.add(itr.next());
		}
		return users;

	}

	public boolean addUser(User user) {
		try {
			employeeRespository.save(user);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public User findUser(int id) {
		return employeeRespository.findOne(id);
	}

	public boolean updateUser(User user, int id) {
		try {
			User userObj = employeeRespository.findOne(id);
			if(userObj != null){
				userObj.setGender(user.getGender());
				userObj.setName(user.getName());
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
