package com.zjw.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zjw.hibernate.demo.entity.Student;

public class CreateStudentDemo {
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save Java object;
			//create a student object
			System.out.println("Start creating object");
			Student tempStudent = new Student("Paul", "V","paul@zjw.com");

			//begin the transaction
			session.beginTransaction();

			//save the object
			session.save(tempStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Transaction Done!");

			
		}finally {
			factory.close();
		}
	}
}
