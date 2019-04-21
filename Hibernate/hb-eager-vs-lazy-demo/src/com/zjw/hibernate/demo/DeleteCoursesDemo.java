package com.zjw.hibernate.demo;

import com.zjw.hibernate.demo.entity.Course;
import com.zjw.hibernate.demo.entity.Instructor;
import com.zjw.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesDemo {
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {

			//begin the transaction
			session.beginTransaction();

			//get a course;
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);

			//delete a course
			System.out.println("Deleting course:" + tempCourse);
			session.delete(tempCourse);




			//commit transaction
			session.getTransaction().commit();
			System.out.println("Transaction Done!");

			
		}finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}
}
