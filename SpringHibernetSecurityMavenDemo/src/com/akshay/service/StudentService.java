package com.akshay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akshay.dao.IStudentDao;
import com.akshay.entity.Student;

@Service
public class StudentService implements IStudentService {

	@Autowired
	IStudentDao studentDao;

	@Transactional
	public String insertStudent(Student student) {
		studentDao.insertStudent(student);
		return null;
	}

	@Override
	@Transactional
	public Student validateLogin(String email, String password, boolean isLoginCall) {
		return studentDao.validateLogin(email, password, isLoginCall);
	}

	@Override
	@Transactional
	public Student registerStudent(Student student) throws Exception {
		student = studentDao.registerStudent(student);
		return student;
	}
}
