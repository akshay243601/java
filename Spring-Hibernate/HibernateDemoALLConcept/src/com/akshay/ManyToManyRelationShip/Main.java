package com.akshay.ManyToManyRelationShip;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.akshay.hibernate.StudentDetail;

public class Main
{
	public static void main(String args[])
	{
		Certification certification = new Certification();
		certification.setCertificationName("Java");
		
		Certification certification1 = new Certification();
		certification1.setCertificationName(".Net");
		
		Certification certification2 = new Certification();
		certification2.setCertificationName("PHP");
		
		Student student = new Student();
		student.setName("Akshay2");
		student.getCertifications().add(certification);
		student.getCertifications().add(certification1);
	
		
		Student student1 = new Student();
		student1.setName("Akshay3");
		student1.getCertifications().add(certification1);
		student1.getCertifications().add(certification2);
		student1.getCertifications().add(certification);
	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();

		session.save(student);
		session.save(student1);
		
		tran.commit();
		session.close();
		sessionFactory.close();	
	}

}
