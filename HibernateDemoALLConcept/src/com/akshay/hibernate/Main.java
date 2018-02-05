package com.akshay.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) 
	{
		Student student = new Student();
		student.setStudentName("Akshay2");

		Student student1 = new Student();
		student1.setStudentName("Akshay3");

		StudentDetail studentDetail = new StudentDetail();
		studentDetail.setStudentMobile("123456");
		studentDetail.setDob(new Date());
		
		studentDetail.setStudent(student);
		
		StudentDetail studentDetail1 = new StudentDetail();
		studentDetail1.setStudentMobile("22323");
		studentDetail1.setDob(new Date());
		studentDetail1.setStudent(student1);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		
		/*session.save(studentDetail);
		session.save(studentDetail1);
		*/
		tran.commit();
		session.close();
		sessionFactory.close();
	}

}
