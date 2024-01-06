package com.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


import com.telusko.Demi.Student;

public class HQLoperations {
	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory fact = con.buildSessionFactory(reg);
		
		
		Session s = fact.openSession();
		Transaction t = s.beginTransaction();
		
//		String query = "from Student where city = 'delhi'";
	    // if create dynaminc to set parameter..
//		String query = "from Student where city =:x";
		
		// we can use alias...
		String query = "from Student as s where s.city =:x and s.name =:r";
		
		
		Query q  = s.createQuery(query);
		q.setParameter("x","uttar pradesh" );
		q.setParameter("r", "Priyanka tiwari");
		
		// single - (unique)
       // multiple - list...
		List<Student> list = q.list();
		for(Student std : list) {
			System.out.println(std.getName()+":" +std.getCerti().getCourse() +":"+std.getCerti().getDurations());
		}
		
		t.commit();
		s.close();
		fact.close();
		
	}

}
