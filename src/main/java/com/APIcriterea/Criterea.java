package com.APIcriterea;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.telusko.Demi.Student;

public class Criterea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory fact =  con.buildSessionFactory();
        Session s = fact.openSession();
        Criteria c = s.createCriteria(Student.class);
        
        // Filter Data from student...
//        c.add(Restrictions.eq("certi.course", "java"));
        
//        c.add(Restrictions.gt("id", 1001));  // gt = Grater Than...
        c.add(Restrictions.lt("id", 1001)); // lt  = less than...
        
        
         List<Student> list = c.list();
        for(Student sd : list) {
        	System.out.println(sd.getRollNo() +" : "+ sd.getName() +" : "+sd.getCerti().getCourse() +" : "+sd.getCerti().getDurations() +" : "+ sd.getCity() );
        }
        s.close();
        fact.close();
	}

}
