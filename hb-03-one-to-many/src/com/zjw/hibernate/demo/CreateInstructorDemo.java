package com.zjw.hibernate.demo;

import com.zjw.hibernate.demo.entity.Course;
import com.zjw.hibernate.demo.entity.Instructor;
import com.zjw.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
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
			//use the session object to save Java object;
			//create a student object
			System.out.println("Start creating object");
			Instructor tempInstructor = 
					new Instructor("Susan", "Public", "susan.public@luv2code.com");
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"http://www.youtube.com/youtube",
							"Video Game");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//begin the transaction
			session.beginTransaction();

			//save the object
			System.out.println("Saving instructor: " + tempInstructor);

			session.save(tempInstructor);//this will also save Detail object;
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Transaction Done!");

			
		}finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}
}
