package com.zemoso.hibernate.demo;

import com.zemoso.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForNaniDemo {

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

			int theId=1;
			// start a transaction
			session.beginTransaction();

			Student student=session.get(Student.class,theId);

			System.out.println("\nLoaded Student "+student);
			System.out.println("Courses : "+ student.getCourses());

			Course tempCourse1 = new Course("C");
			Course tempCourse2 = new Course("CPP");

			tempCourse1.addStudent(student);
			tempCourse2.addStudent(student);

			System.out.println("\n Saving the courses...");

			session.save(tempCourse1);
			session.save(tempCourse2);

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
