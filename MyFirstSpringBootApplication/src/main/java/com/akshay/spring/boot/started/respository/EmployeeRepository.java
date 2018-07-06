package com.akshay.spring.boot.started.respository;

import org.springframework.data.repository.CrudRepository;

import com.akshay.spring.boot.started.entity.User;

public interface EmployeeRepository extends CrudRepository<User, Integer> {
	public User findByName(String name);
}
