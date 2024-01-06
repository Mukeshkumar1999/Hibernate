package com.sqlQuery;


import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


import com.telusko.Demi.Student;

public class NativeSql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory fact = con.buildSessionFactory(reg);
		
		Session s = fact.openSession();
		String q = "select * from student";
		  SQLQuery sqlQuery = s.createSQLQuery(q);
		   List<Object[]> list=sqlQuery.list();
		   for(Object[] arr : list) {
//			   System.out.println(Arrays.toString(arr));
			   System.out.println(arr[4]+" : " + arr[3]);
		   }
		
		s.close();
		fact.close();

	}

}
