package com.zjw.hibernate.demo;

import com.zjw.hibernate.demo.entity.Course;
import com.zjw.hibernate.demo.entity.Instructor;
import com.zjw.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateICourseAndReviewDemo {
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

			// get the instructor info from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);


			// create some courses;
			Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
			Course tempCourse2 = new Course("The Pinball Masterclass");

			//add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);

			//save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);

			session.getTransaction().commit();
			System.out.println("Transaction Done!");

			
		}finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}
}
