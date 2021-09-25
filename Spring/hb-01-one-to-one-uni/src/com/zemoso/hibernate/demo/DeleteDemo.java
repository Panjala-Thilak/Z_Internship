package com.zemoso.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zemoso.hibernate.demo.entity.*;
public class DeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try
		{
		
			
			session.beginTransaction();
			
			int theId=3;
			Instructor instructor=session.get(Instructor.class,theId);
			
			System.out.println("Found Instructor: "+instructor);
			
			if(instructor!=null)
			{
				System.out.println("Deleting: "+instructor);
				
				//note: will delete associated "details" object because of 
				//CASCADETYPE ALL
				session.delete(instructor);
			}
			
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		}
		finally {
			factory.close();
		}
		
	}

}
