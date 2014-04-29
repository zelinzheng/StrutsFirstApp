package com.dbutil;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.Transactions;


public class DaoTransaction {
	public static void main(String[] args) {
		//Transactions tran = new Transactions("zelin","admin","200", new Date());
		//insertTransaction( tran);
		List ls = getAllTransToUn("zelin");
		for (Object object : ls) {
			System.out.println(object);
		}
		showAllTransaction();
	}
	
	public static void showAllTransaction() {
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("from Transactions");
		List<?> lu = query.list();
		for (Object object : lu) {
			System.out.println(object);
		}
	}
	
	public static List getAllTrans() {
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("from Transactions");
		List<?> lu = query.list();
		return lu;
	}
	
	public static List getAllTransFromUn(String un) {
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("from Transactions where un = :un");
		query.setParameter("un", un);
		List<?> lu = query.list();
		return lu;
	}
	
	public static List getAllTransByUn(String un) {
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("from Transactions where un = :un or targetun = :un");
		query.setParameter("un", un);
		List<?> lu = query.list();
		return lu;
	}
	
	public static List getAllTransToUn(String un) {
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("from Transactions where targetun = :un");
		query.setParameter("un", un);
		List<?> lu = query.list();
		return lu;
	}
	
	public static void insertTransaction(Transactions tran) {
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		s.save(tran);
		t.commit();
	}
}
