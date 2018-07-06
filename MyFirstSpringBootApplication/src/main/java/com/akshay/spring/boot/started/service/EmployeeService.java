package com.akshay.spring.boot.started.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.spring.boot.started.dao.EmployeeDao;
import com.akshay.spring.boot.started.entity.User;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public List<User> listUsers() {
		return employeeDao.listUsers();
	}

	public User findUser(int id) {
		return employeeDao.findUser(id);
	}
	
	public boolean addUser(User user) {
		return employeeDao.addUser(user);
	}

	public boolean updateUser(User user, int id) {
		return employeeDao.updateUser(user, id);
	}


}
