package com.akshay.dao;

import com.akshay.entity.Student;

public interface IStudentDao 
{
	void insertStudent(Student student);
	
	Student validateLogin(String email, String password, boolean isLogicCall);

	Student registerStudent(Student student);

}
