package com.cascading;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.map.Laptop;
import com.map.Person;

public class CascadingPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration con = new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory fact = con.buildSessionFactory(reg);
		Session session = fact.openSession();
		
		Person pr = new Person();
		pr.setId(601);
		pr.setPname("Gauri Singh");
		
		
		 Laptop lp1 =new Laptop();
		 lp1.setId(500);
		 lp1.setLapName("Agani lap");
		 lp1.setPerson(pr);
		 Laptop lp2 =new Laptop();
		 lp2.setId(499);
		 lp2.setLapName("Sony");
		 lp2.setPerson(pr);
		 Laptop lp3 =new Laptop();
		 lp3.setId(498);
		 lp3.setLapName("MSI");
		 lp3.setPerson(pr);
		 
		 ArrayList<Laptop> li = new ArrayList<>();
		 li.add(lp1);
		 li.add(lp2);
		 li.add(lp3);
		 pr.setLaptop(li);
		 Transaction tr= session.beginTransaction();
		 
		 // Cascade to use save automatic laptop.. data.
		 session.save(pr);
		 tr.commit();
		 session.close();
		 fact.close();
		 
		

	}

}
