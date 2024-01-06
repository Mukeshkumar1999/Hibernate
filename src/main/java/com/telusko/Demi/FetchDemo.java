package com.telusko.Demi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FetchDemo {
	public static void main(String[] args) {
		 // get() and load()....
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
	      
	       
	       SessionFactory sf = con.buildSessionFactory();
	       Session session = sf.openSession();
	       
	       // get alien 105;
	      Alien aln  = (Alien)session.get(Alien.class,105);
	       System.out.print(aln);
	       System.out.println();
	       
	       // load alien 106..
//	       Alien alnl  = (Alien)session.load(Alien.class,106);
//	       System.out.println(alnl);
	       
	       Address adg = (Address) session.get(Address.class, 1);
	       System.out.println(adg);
	       session.close();
	       sf.close();
		
		
	}

}
