package com.akshay.service;

import com.akshay.dao.IStudentDao;
import com.akshay.entity.Student;

public interface IStudentService{

	String insertStudent(Student student);

	Student validateLogin(String email, String password, boolean isLoginCall);

	Student registerStudent(Student student) throws Exception;
}
