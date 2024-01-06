package com.hql;

//import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.map.Laptop;
import com.map.Person;
import com.telusko.Demi.Student;

public class DeleteUpdateJoin {
	public static void main(String[] args) {
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Person.class).addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory fact = con.buildSessionFactory(reg);
		
		Session s = fact.openSession();
		Transaction t = s.beginTransaction();
		
		// 1. Delete Query...
		
//		Query q = s.createQuery("delete from Student as s where s.city =:c");
//		q.setParameter("c", "Delhi");
//		
//		int op = q.executeUpdate();
//		System.out.println("deleted...");
//		System.out.println(op);
		
		// 2. Update Query..
		
//		 Query q1 = s.createQuery("update Student set city =:c where name=:n" );
//		 q1.setParameter("c", "jaipur");
//		 q1.setParameter("n", "priyanka tiwari");
//		  int r = q1.executeUpdate();
//		 System.out.println(r +":"+"updatedd");
		
		
		
		t.commit();
		// Join Query...
//				Query q3 = s.createQuery("select p.pname, p.id,l.lapName from Person as p INNER JOIN p.laptop as l");
//			  List<Object[]>list2 = q3.list();
//			  for(Object[] arr : list2) {
//				  System.out.println(Arrays.toString(arr));
//			  }
		            
		s.close();
		fact.close();
	}

}
