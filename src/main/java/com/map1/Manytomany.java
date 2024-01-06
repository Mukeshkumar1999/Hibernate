package com.map1;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

//import com.sun.tools.javac.util.List;

public class Manytomany {
	public static void main(String[] args) {

		Configuration con = new Configuration().configure().addAnnotatedClass(Emp.class)
				.addAnnotatedClass(Project.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory factory = con.buildSessionFactory(reg);

		// Creating employe obj...
		Emp e1 = new Emp();
		
		e1.seteId(1001);
		e1.seteName("priya");
		e1.seteCity("Canada");
		
        Emp e2 = new Emp();
		e2.seteId(1002);
		e2.seteName("Monu Kumar");
		e2.seteCity("Punjab");
		
        Emp e3 = new Emp();
		e3.seteId(1003);
		e3.seteName("sunny kumar");
		e3.seteCity("Delhi");
		
		// Creating Project obj...
		
		Project p1 = new Project();
		p1.setProjectId(101);
		p1.setProjectName("Banking System");
		
		Project p2 = new Project();
		p2.setProjectId(102);
		p2.setProjectName("Whatsapp cloan");
		
		Project p3 = new Project();
		p3.setProjectId(103);
		p3.setProjectName("ChatBot");
		
		ArrayList<Emp>  list1 = new ArrayList<Emp>();
		ArrayList<Project> list2 = new ArrayList<Project>();
		list2.add(p1);
		list2.add(p2);
		list2.add(p3);
		list1.add(e1);
		list1.add(e2);
		list1.add(e3);
		e1.setProject(list2);
		e2.setProject(list2);
		e3.setProject(list2);
		p1.setEmploye(list1);
		p2.setEmploye(list1);
		p3.setEmploye(list1);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(e1);
		session.save(e2);
		session.save(e3);
		
		// Fetchin data from databases;
		
//		Emp e = (Emp) session.get(Emp.class, 1001);
//		System.out.println(e.geteName() +":"+ e.geteId()+":"+ e.geteCity());
//		for(Project val : e.getProject()) {
//			System.out.println(val.getProjectName()+":"+ val.getProjectId());
//		}

		tx.commit();
		session.close();
		factory.close();
	}

}
