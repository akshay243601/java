package com.akshay.spring.boot.started.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.spring.boot.started.entity.User;
import com.akshay.spring.boot.started.entity.UserItem;
import com.akshay.spring.boot.started.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String sayHello() {
		return "hello";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public boolean saveUser(@RequestBody User user) {
		return employeeService.addUser(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/save/{id}")
	public boolean saveUser(@RequestBody User user, @PathVariable int id) {
		return employeeService.updateUser(user, id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	public User findUser(@PathVariable(value = "id") int id) {
		return employeeService.findUser(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/userByName/{name}")
	public User findUserByName(@PathVariable(value = "name") String name) {
		return employeeService.findUserByName(name);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public List<User> listUsers() {
		return employeeService.listUsers();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{userName}/items")
	public List<UserItem> findItemsByUserName(@PathVariable String userName) {
		return employeeService.findItemsByUserName(userName);
	}
}
