package com.telusko.Demi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class EmbeddingDemo {
	public static void main(String[] args) {
		 Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
	       // reg obj to avoid dublicate data...
	       ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	       SessionFactory sf = con.buildSessionFactory(reg);
	       
	       
	       Student st = new Student();
	       st.setRollNo(1003);
	       st.setName("Rahan Mehta");
	       st.setCity("hyderabad");
	       
	       
	       Certificate cet = new Certificate();
	       cet.setCourse("Springboot");
	       cet.setDurations("82 hours 30 mint");
	       st.setCerti(cet);
	       
	       Student st2 = new Student();
	       st2.setRollNo(1004);
	       st2.setName("Vivek Sharma");
	       st2.setCity("Delhi NCR");
	       
	       
	       Certificate cet2 = new Certificate();
	       cet2.setCourse("Hibernate");
	       cet2.setDurations("2 Months");
	       st2.setCerti(cet2);
	       
	       Session sn = sf.openSession();
	       Transaction tz = sn.beginTransaction();
	       sn.save(st);
	       sn.save(st2);
	       tz.commit();
//	       sn.close();
//	       sf.close();
	}

}
