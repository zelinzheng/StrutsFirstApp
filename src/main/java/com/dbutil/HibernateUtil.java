package com.dbutil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf= null;
	
	public static Session getSession() {
		if(sf == null) {
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
			sf = cfg.buildSessionFactory();
		}
		
		return sf.openSession();
	}
}
