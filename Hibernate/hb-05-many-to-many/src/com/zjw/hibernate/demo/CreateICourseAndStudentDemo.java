package com.zjw.hibernate.demo;

import com.zjw.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateICourseAndStudentDemo {
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

			//create a course;
			Course tempCourse = new Course("Pacman - How To Score one");

			//save the course;
			session.save(tempCourse);

			//create the student
			Student tempStudent1 = new Student("John","Doe","JD@neu.edu");
			Student tempStudent2 = new Student("Jianwei" , "Zhang", "zjw@neu.edu");

			//save the student with course;
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);

			session.save(tempStudent1);
			session.save(tempStudent2);

			session.getTransaction().commit();
			System.out.println("Done!");

			
		}finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}
}
