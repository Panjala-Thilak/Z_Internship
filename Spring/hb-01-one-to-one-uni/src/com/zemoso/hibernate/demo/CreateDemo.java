package com.zemoso.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zemoso.hibernate.demo.entity.*;
public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try
		{
		/*	Instructor instructor=new Instructor("thilak","panjala","thilak@gmail.com");

			com.zemoso.hibernate.demo.entity.InstructorDetail instructorDetail=new InstructorDetail("ThilakToutube","Watching Youtube");
*/
			
			Instructor instructor=new Instructor("thilak2","pan","nani@gmail.com");

			InstructorDetail instructorDetail=new InstructorDetail("http://nani/youtube","Watching youtube");

			instructor.setInstructorDetail(instructorDetail);

			session.beginTransaction();
			
			System.out.println("Saving instructor: "+instructor);
			session.save(instructor);

			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		}
		finally {
			factory.close();
		}
		
	}

}
