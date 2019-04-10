package com.zjw.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zjw.hibernate.demo.entity.Student;

public class QueryStudentDemo {
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {

			//begin the transaction
			session.beginTransaction();	
			
			//Query students;
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display students;
			displayStudents(theStudents);
			
			//query the students with last name:Doe
			theStudents = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
			System.out.println("the Student whos last name is of Duck");
			displayStudents(theStudents);

			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Transaction Done!");

			
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents)
			System.out.println(tempStudent);
	}
}
