package com.zemoso.hibernate.demo;

import com.zemoso.hibernate.demo.entity.Course;
import com.zemoso.hibernate.demo.entity.Instructor;
import com.zemoso.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

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

			Course course1=new Course("python");
			Course course2=new Course("java");

			instructor.add(course1);
			instructor.add(course2);

			session.save(course1);
			session.save(course2);

			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		}
		finally {
			session.close();
			factory.close();
		}
		
	}

}
