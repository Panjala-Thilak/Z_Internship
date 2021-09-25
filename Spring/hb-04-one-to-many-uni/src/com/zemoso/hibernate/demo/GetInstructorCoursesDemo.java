package com.zemoso.hibernate.demo;

import com.zemoso.hibernate.demo.entity.Course;
import com.zemoso.hibernate.demo.entity.Instructor;
import com.zemoso.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {

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


			session.beginTransaction();
			
			int theId=1;
			Instructor instructor=session.get(Instructor.class,theId);

			System.out.println("Instructor  : "+instructor);

			System.out.println("Courses : "+instructor.getCourses());

			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		}
		finally {
			session.close();
			factory.close();
		}
		
	}

}
