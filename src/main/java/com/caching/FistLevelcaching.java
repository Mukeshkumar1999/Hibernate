package com.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.telusko.Demi.Alien;

public class FistLevelcaching {
	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory fact  = con.buildSessionFactory(reg);
		
		
		Session sess = fact.openSession();
		  Alien al = (Alien)sess.get(Alien.class, 105);
		  
		  System.out.println(al);
		  
		  System.out.println("again get");
		  
		  Alien al2 = (Alien)sess.get(Alien.class, 105);
		 System.out.println(al2);
		 
		 
		 System.out.println(sess.contains(al2));
		 
		
		sess.close();
		
		
		fact.close();
	}

}
