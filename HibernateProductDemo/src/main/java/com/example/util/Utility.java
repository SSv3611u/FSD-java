package com.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utility {

	private static SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			System.out.println("SessionFactory created!");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SessionFactory failed!");
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		if (sessionFactory != null) {
			sessionFactory.close();
			System.out.println("SessionFactory closed.");
		}
	}
}