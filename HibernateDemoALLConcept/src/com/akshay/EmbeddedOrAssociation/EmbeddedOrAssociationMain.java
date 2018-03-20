package com.akshay.EmbeddedOrAssociation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddedOrAssociationMain 
{
	public static void main(String args[])
	{
		Employee emp = new Employee();
		emp.setName("Akshay");
	
		
		Address adr = new Address();
		adr.setAddressId(11);
		adr.setAddressName("Hyderabad11");
		
		emp.setAddress(adr);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.getTransaction();
		tx.begin();
		
		
		session.save(emp);
		
		tx.commit();
	
		Employee ee = (Employee)session.get(Employee.class, 1);
		System.out.println(ee.getAddress().getAddressName());
	}
}
