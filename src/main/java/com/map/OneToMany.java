package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class OneToMany {
	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory factory = con.buildSessionFactory(reg);
		
		Person person = new Person();
		person.setId(11);
		person.setPname("Jai Kishan");
		
		
		Laptop laptop = new Laptop();
		laptop.setId(0005);
		laptop.setLapName("MackBook Air");
		laptop.setPerson(person);
		
		Laptop laptop1 = new Laptop();
		laptop1.setId(36364);
		laptop1.setLapName("HP Pavilion");
		laptop1.setPerson(person);
		Laptop laptop2 = new Laptop();
		laptop2.setId(2340);
		laptop2.setLapName("Acer Aspire Lite");
		laptop2.setPerson(person);
		
		List<Laptop> list = new ArrayList<Laptop>();
		list.add(laptop);
		list.add(laptop1);
		list.add(laptop2);
		person.setLaptop(list);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(person);
		session.save(laptop);
		session.save(laptop1);
		session.save(laptop2);
		
//		// Fetching data..
//		Person pr = (Person)session.get(Person.class, 11);
//		System.out.println(pr.getPname());
//		for(Laptop val : pr.getLaptop()) {
//			System.out.println(val.getLapName());
//		}
		
		tx.commit();
		
		session.close();
		factory.close();
		
	}

}
