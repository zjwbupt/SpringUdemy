package com.zjw.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zjw.hibernate.demo.entity.Instructor;
import com.zjw.hibernate.demo.entity.InstructorDetail;
import com.zjw.hibernate.demo.entity.Student;

public class CreateDemo {
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save Java object;
			//create a student object
			System.out.println("Start creating object");
			Instructor tempInstructor = 
					new Instructor("Chad", "Darby", "darby@luv2code.com");
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"http://www.luv2code.com/youtube",
							"Luv 2 code!!!");
			
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
			factory.close();
		}
	}
}
