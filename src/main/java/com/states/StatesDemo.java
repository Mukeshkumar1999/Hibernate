package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.telusko.Demi.Certificate;
import com.telusko.Demi.Student;

public class StatesDemo {
	public static void main(String[] args) {
		// Hibernate they have four types of states ..
		// 1. Transient state..
		// 2. Persistent state..
		// 3. Detached state..
		// 4. Removed state..
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Certificate.class);
		SessionFactory sf = con.buildSessionFactory();
		
		// creating student obj..
		Student st = new Student();
		st.setRollNo(555);
		st.setName("Pradeep sharma");
		st.setCity("Uttar Pradesh");
		st.setCerti(new Certificate("java hibernate","2 moths"));
		//1. student : transient...
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(st);
	   //2. Student : Persistent..  session , databases...
		 st.setName("Priyanka tiwari"); // it can be changes is possible to change from database..
		t.commit();
		
		s.close();
		// 3. student : Detached states...
	
	}

}
