package com.zjw.hibernate.demo;

import com.zjw.hibernate.demo.entity.Instructor;
import com.zjw.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
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

			//begin the transaction
			session.beginTransaction();

			//get the instructor detail object
			int theId = 2123123;
			InstructorDetail tempInstructorDetail =
					session.get(InstructorDetail.class, theId);

			//print the instructor detail
			System.out.println("tempInstructorDetail: "+ tempInstructorDetail);

			//print the assosciated instructor
			System.out.println("the associated instructor: " +
					tempInstructorDetail.getInstructor());

			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Transaction Done!");

			
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}
}
