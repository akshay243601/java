package com.akshay.rest.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryBLImpl {
	public static SessionFactory sessionFactory = null;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			synchronized (SessionFactoryBLImpl.class) {
				if (sessionFactory == null) {
					sessionFactory = new Configuration().configure().buildSessionFactory();
				}
			}
		}
		return sessionFactory;
	}
}
