package com.zemoso.hibernate.demo;

import com.zemoso.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();


			// create a course
			Course tempCourse = new Course("Python");

			System.out.println("Saving the course: "+tempCourse);
			session.save(tempCourse);

			System.out.println("Saved the course.");

			Student student1=new Student("pragna","bandi","nani@gmail.com");
			Student student2=new Student("nisanth","katanguri","kou@yahoo.com");

			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);

			System.out.println("\nSaving the Students...");
			session.save(student1);
			session.save(student2);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}
		finally {

			// add clean up code
			session.close();

			factory.close();
		}
	}

}
