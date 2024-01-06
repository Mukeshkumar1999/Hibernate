package com.pagination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.telusko.Demi.Alien;


public class HQLpagination {
	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory fact = con.buildSessionFactory(reg);
		
		Session s = fact.openSession();
		
		Query q = s.createQuery("fron Alien");
		
		// implement pegination using  hibernate.......
		q.setFirstResult(0); // where to start get element..
		q.setMaxResults(3);  // get many element..
		
		List<Alien> li = q.list();
		for(Alien val : li) {
//			System.out.println(val.getId()+" : "+val.getName()+" : "+val.getColor());
			
		}
		s.close();
		fact.close();
		
	}

}
