package com.cachesecond;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.cache.ehcache.EhCacheRegionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.telusko.Demi.Alien;

public class SecondLevelCache {
public static void main(String[] args) {
	
	 
	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	SessionFactory fact  = con.buildSessionFactory(reg);
	// below notation is most imp to set the full packege name to set cfg.xml property...
//    EhCacheRegionFactory
	
	 // Second level session are use we are creating multiple session and get the same obj querry fire only one time and give result..
	Session sess1 = fact.openSession();
    Alien al1 =(Alien) sess1.get(Alien.class, 107);
    System.out.println(al1);
	
	sess1.close();
	
	Session sess2 = fact.openSession();
	Alien al2 =(Alien) sess2.get(Alien.class, 107);
    System.out.println(al2);
	sess2.close();
}
}
