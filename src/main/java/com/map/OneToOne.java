package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class OneToOne {
	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Question.class).addAnnotatedClass(Answer.class);
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory factory = con.buildSessionFactory(reg);
		
		// Creating questin obj...
		Question qus = new Question();
		qus.setQuestionId(1212);
		qus.setQuestion("what is java ?");
		
		Answer ans = new Answer();
		ans.setAnswerId(343);
		ans.setAnswer("Java is the programing language");
		qus.setAnswer(ans);
		
		Question qus1 = new Question();
		qus1.setQuestionId(02);
		qus1.setQuestion("What is collection framework  ?");
		
		Answer ans1 = new Answer();
		ans1.setAnswerId(3044);
		ans1.setAnswer("API to work with object in java ");
		qus1.setAnswer(ans1);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(qus);
		session.save(ans);
		session.save(qus1);
		session.save(ans1);
		tx.commit();
		
		// Fetchin data into databases;
		
		Question q = (Question)session.get(Question.class, 1212);
		System.out.println(q.getQuestion());
		System.out.print(q.getAnswer().getAnswer());
		
		
		session.close();
		factory.close();
		
		
	}

}
