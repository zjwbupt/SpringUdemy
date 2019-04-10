package com.zjw.hibernate.demo;

import com.zjw.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {

			//begin the transaction
			session.beginTransaction();

			//get student Jianwei from database
			int courseId = 10;
			Course tempCourse = session.get(Course.class,courseId);

			session.delete(tempCourse);


			session.getTransaction().commit();
			System.out.println("Done!");

			
		}finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}
}
