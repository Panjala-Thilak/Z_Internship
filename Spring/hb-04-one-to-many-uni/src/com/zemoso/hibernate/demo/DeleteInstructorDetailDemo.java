package com.zemoso.hibernate.demo;

import com.zemoso.hibernate.demo.entity.Instructor;
import com.zemoso.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

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

			int theId=4;
			InstructorDetail instructorDetail=session.get(InstructorDetail.class,theId);

			System.out.println("Instructor details"+instructorDetail);

			System.out.println("The associated instructor: "+instructorDetail.getInstructor());

			System.out.println("Deleting instructor detail : "+instructorDetail);

			instructorDetail.getInstructor().setInstructorDetail(null);

			session.delete(instructorDetail);

			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		}
		catch (Exception exe)
		{
			exe.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
		
	}

}
