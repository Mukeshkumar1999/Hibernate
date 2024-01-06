package com.telusko.Demi;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// creating obj of Alien class..
       Alien telusko = new Alien();
       telusko.setId(107);
       telusko.setName("LOKI");
       telusko.setColor("Marval comicbook");
       // creating Address obj class;
       Address ad = new Address();
       ad.setStreet("Street3");
       ad.setCity("America");
       ad.setOpen(true);
       ad.setAddedDate(new Date());
       ad.setX(126.43);
       
       //mapping there are two types ..
       // 1. addAnnotatedClass()..
       // 2. xml file mapping..
       Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Address.class);
       // reg obj to avoid dublicate data...
       ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
       SessionFactory sf = con.buildSessionFactory(reg);
       
       Session session = sf.openSession();
       Transaction tx = session.beginTransaction();
      session.save(telusko);
      session.save(ad);
       tx.commit();
      System.out.print(telusko);
      System.out.print(ad);
    }
}
