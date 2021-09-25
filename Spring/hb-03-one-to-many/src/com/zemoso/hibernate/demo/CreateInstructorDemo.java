package com.zemoso.hibernate.demo;

import com.zemoso.hibernate.demo.entity.Course;
import com.zemoso.hibernate.demo.entity.Instructor;
import com.zemoso.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try
		{
			
			Instructor instructor=new Instructor("thilak","panjala","thilak@gmail.com");

			InstructorDetail instructorDetail=new InstructorDetail("http://thilak/youtube","Watching Instagram");

			instructor.setInstructorDetail(instructorDetail);

			session.beginTransaction();
			
			System.out.println("Saving instructor: "+instructor);
			session.save(instructor);

			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		}
		finally {
			session.close();
			factory.close();
		}
		
	}

}
