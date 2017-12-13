package com.akshay.dao;

import java.util.List;

import org.apache.maven.artifact.versioning.Restriction;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.akshay.entity.Student;

@Component
public class StudentDaoImpl implements IStudentDao 
{
	@Autowired
	SessionFactory sessionFactory;
	public void insertStudent(Student student) 
	{
		sessionFactory.getCurrentSession().save(student);
	}
	
	@Override
	public Student validateLogin(String email, String password, boolean isLoginCall) {
		
		Query query = null;
		if(isLoginCall)
		{
			query = sessionFactory.getCurrentSession().createQuery("from Student where email=? and password=?");
			
		
			query.setParameter(0, email);
			query.setParameter(1, password);		
		}
		else
		{
			query = sessionFactory.getCurrentSession().createQuery("from Student where email=?");
			query.setParameter(0, email);
		}
		List<Student> studentList = query.list();
		
		Student student = null;
		if(studentList != null && studentList.size() > 0)
		{
			student = studentList.get(0);
		}
		return student;
	}
	
	@Override
	public Student registerStudent(Student student) 
	{
		sessionFactory.getCurrentSession().save(student);
		return student;
	}
	
}
