package com.mappingxml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class XmlTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration con = new Configuration().configure();
		SessionFactory fact = con.buildSessionFactory();
		
		// creatin obj ..
		House h = new House();
		h.setHid(0001);
		h.sethName("Vasant Kunj");
		h.setOwnerName("EswarChand Singh");
		Session s = fact.openSession();
		Transaction tx = s.beginTransaction();
		s.save(h);
		tx.commit();
		s.close();
		fact.close();

	}

}
