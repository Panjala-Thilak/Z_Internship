package com.zemoso.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zemoso.hibernate.demo.entity.*;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try
		{
			System.out.println("Creating new student object");
			
			Student student=new Student("thilak","panjala","panjalathilak@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("saving the student...");
			
			session.save(student);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		}
		finally {
			factory.close();
		}
		
	}

}
