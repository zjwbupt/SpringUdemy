package com.zjw.hibernate.demo;

import com.zjw.hibernate.demo.entity.Instructor;
import com.zjw.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
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
			//get instructor by primary key
			int theId = 1;
			Instructor tempInstructor =
					session.get(Instructor.class,theId);
			System.out.println("Found Instructor: " + tempInstructor);

			//delete the instructor

			if(tempInstructor != null){
				System.out.println("Deleting: " + tempInstructor);
				//note: detail object will be delete too.
				session.delete(tempInstructor);
			}

			session.getTransaction().commit();
			System.out.println("Transaction Done!");

			
		}finally {
			factory.close();
		}
	}
}
