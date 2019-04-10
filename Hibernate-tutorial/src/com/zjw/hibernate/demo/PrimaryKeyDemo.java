package com.zjw.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zjw.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try {
					//use the session object to save Java object;
					
					//create 3 student objects
					System.out.println("Start creating 3 object");
					Student tempStudent1 = new Student("John", "Doe","@zjw.com");
					Student tempStudent2 = new Student("Mary", "Public","mary@zjw.com");
					Student tempStudent3 = new Student("Bony", "CC","bony@zjw.com");


					//begin the transaction
					session.beginTransaction();

					//save the object
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);

					
					//commit the transaction
					session.getTransaction().commit();
					System.out.println("Transaction Done!");

					
				}finally {
					factory.close();
				}		
	}

}
